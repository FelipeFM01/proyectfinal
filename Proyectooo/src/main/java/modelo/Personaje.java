package modelo;

public class Personaje {
    private String clase;
    private String nombrePersonaje;
    private String raza;
    private String subRaza;    // las clases seran las categorias distintivas en lugar de hacerlo por raza y clase a la vez
    private String alineamiento;
    private String trasfondo;
    private String equipo;
    private String rasgo;
    private String arquetipo;



    // hacer restriccion para el equipo  (arma primaria y/o secundaria)

    //  tambien puede ser Solo un arma



    public Personaje(String clase, String nombrePersonaje, String raza, String subRaza, String alineamiento, String trasfondo, String equipo, String rasgo, String arquetipo){
        this.clase = clase;
        this.nombrePersonaje = nombrePersonaje;
        this.raza = raza;
        this.subRaza = subRaza;
        this.alineamiento = alineamiento;
        this.trasfondo = trasfondo;
        this.equipo = equipo;
        this.rasgo = rasgo;
        this.arquetipo = arquetipo;
    }

    public String getClase() {return clase;}
    public void setClase(String clase) {this.clase = clase;}

    public String getNombrePersonaje() {return nombrePersonaje;}
    public void setNombrePersonaje(String nombrePersonaje) {this.nombrePersonaje = nombrePersonaje;}

    public String getRaza() {return raza;}
    public void setRaza(String raza) {this.raza = raza;}

    public String getSubRaza() {return subRaza;}
    public void setSubRaza(String sub_raza) {this.subRaza = subRaza;}

    public String getAlineamiento() {return alineamiento;}
    public void setAlineamiento(String alineamiento) {this.alineamiento = alineamiento;}

    public String getTrasfondo() {return trasfondo;}
    public void setTrasfondo(String trasfondo) {this.trasfondo = trasfondo;}

    public String getEquipo() {return equipo;}
    public void setEquipo(String equipo) {this.equipo = equipo;}

    public String getRasgo() {return rasgo;}
    public void setRasgo(String rasgo) {this.rasgo = rasgo;}

    public String getArquetipo() {return arquetipo;}
    public void setArquetipo(String arquetipo) {this.arquetipo = arquetipo;}

}
