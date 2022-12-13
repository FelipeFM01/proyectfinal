package modelo.data.dao;

import modelo.Usuario;
import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;

public class UsuarioDAO {
    private static DSL query;
    public static void agregarUsuario(DSLContext query, Usuario usuario){
        Table tablaUsuario= DSL.table(name("Usuario"));
        Field[] columnas = tablaUsuario.fields("nombre","nombrePersonaje", "contraseña", "correo");
        query.insertInto(tablaUsuario, columnas[0], columnas[1],columnas[2], columnas[3])
                .values(usuario.getNombre(),usuario.getNombrePersonaje(),usuario.getContraseña(),usuario.getCorreo())
                .execute();

    }


    public static void modificarUsuario(String nombrePersonaje, String columnaTabla, Object dato){
        query.update(DSL.table("Usuario")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("nombrePersonaje").eq(nombrePersonaje)).execute();
    }
    public static List obtenerUsuario(DSLContext query, String columnaTabla, Object dato) {
        Result resultados = query.select().from(DSL.table("Usuario")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaUsuarios(resultados);
    }
    public static List obtenerUsuarios(DSLContext query){
        Result resultados = query.select().from(DSL.table("Usuario")).fetch();
        return obtenerListaUsuarios(resultados);
    }



    public void eliminarUsuario(DSLContext query, String nombrePersonaje){
        Table tablaUsuario= DSL.table(name("Usuario"));
        query.delete(DSL.table("Usuario")).where(DSL.field("nombrePersonaje").eq(nombrePersonaje)).execute();
    }

    private static List obtenerListaUsuarios(Result resultados){
        List<Usuario> usuarios= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String nombre = (String) resultados.getValue(fila,"nombre");
            String nombrePersonaje = (String) resultados.getValue(fila,"nombrePersonaje");
            String correo = (String) resultados.getValue(fila,"correo");
            String contraseña = (String) resultados.getValue(fila,"contraseña");
            usuarios.add(new Usuario(nombre,nombrePersonaje,correo,contraseña));
        }
        return usuarios;
    }
}
