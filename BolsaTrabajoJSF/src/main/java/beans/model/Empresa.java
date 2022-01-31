package beans.model;

public class Empresa {
    private int idEmpresa;
    private String nombre;
    private String logo;
    
    public Empresa() {
        
    }

    public Empresa(int idEmpresa, String nombre, String logo) {
        this.idEmpresa = idEmpresa;
        this.nombre = nombre;
        this.logo = logo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
