package modelo;

public class Usuario {
    private String nombre;
    private String nombrePersonaje; // hacer metodo para que indique si el personaje existe o no¡¡¡¡¡¡¡¡¡¡¡
    private String contraseña;
    private String correo;

    public Usuario(String nombre, String nombrePersonaje, String contraseña, String correo){
        this.nombre = nombre;
        this.nombrePersonaje = nombrePersonaje;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public String getNombrePersonaje() {return nombrePersonaje;}
    public void setNombrePersonaje(String nombrePersonaje) {
        this.nombrePersonaje = nombrePersonaje;
    }


    public String getContraseña() {return contraseña;}
    public void setContraseña(String contraseña) {this.contraseña = contraseña;}

    public String getCorreo() {return correo;}
    public void setCorreo(String correo) {this.correo = correo;}

}
