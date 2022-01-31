package beans.helper;

import beans.model.Empresa;
import beans.model.Oferta;
import java.io.InputStream;
import java.sql.*;
import java.util.*;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class DatosHelper {
    private static final String SQL_SELECT = "SELECT idOferta, nombre, sueldo, provincia, tecnologia, link, cod_empresa"
            + " FROM oferta WHERE provincia=? AND tecnologia=?";
    
    private static final String SQL_SELECT_BY_ID = "SELECT idEmpresa, nombre, logo FROM empresa WHERE idEmpresa = ?";
    
    public List<Oferta> listar(String candidatoProvincia, String candidatoTecnologia) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Oferta oferta;
        List<Oferta> ofertas = new ArrayList<>();
        Empresa empresa;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            stmt.setString(1, candidatoProvincia);
            stmt.setString(2, candidatoTecnologia);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idOferta = rs.getInt("idOferta");
                String nombre = rs.getString("nombre");
                Double sueldo = rs.getDouble("sueldo");
                String provincia = rs.getString("provincia");
                String tecnologia = rs.getString("tecnologia");
                String link = rs.getString("link");
                int codEmpresa = rs.getInt("cod_empresa");

                empresa = getEmpresa(codEmpresa);
                
                oferta = new Oferta(idOferta, nombre, sueldo, provincia, tecnologia, link, empresa);
                ofertas.add(oferta);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return ofertas;
    }
    
    public Empresa getEmpresa(int codEmpresa) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empresa empresa = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, codEmpresa);
            rs = stmt.executeQuery();
            if (rs.next()) {
                int idEmpresa = rs.getInt("idEmpresa");
                String nombre = rs.getString("nombre");
                String logo = rs.getString("logo");

                empresa = new Empresa(idEmpresa, nombre, logo);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return empresa;
    }
}
