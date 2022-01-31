package beans.model;

public class Oferta {
    private int idOferta;
    private String nombre;
    private double sueldo;
    private String provincia;
    private String tecnologia;
    private String link;
    private Empresa empresa;
    
    public Oferta() {
        
    }

    public Oferta(int idOferta, String nombre, double sueldo, String provincia, String tecnologia, String link, Empresa empresa) {
        this.idOferta = idOferta;
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.provincia = provincia;
        this.tecnologia = tecnologia;
        this.link=link;
        this.empresa = empresa;
    }
    
    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTecnologia() {
        return tecnologia;
    }

    public void setTecnologia(String tecnologia) {
        this.tecnologia = tecnologia;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
    
    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
