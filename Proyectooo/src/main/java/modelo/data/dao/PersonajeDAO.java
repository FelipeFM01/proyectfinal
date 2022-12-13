package modelo.data.dao;

import modelo.Personaje;
import org.jooq.*;
import org.jooq.Record;
import org.jooq.impl.DSL;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.impl.DSL.name;
import static org.jooq.impl.DSL.table;

public class PersonajeDAO {

    private static DSL query;
    public static void setQuery(DSL query) {PersonajeDAO.query = query;}


    public static void agregarPersonaje(DSLContext query, Personaje personaje){
        Table<Record> tablaPersonaje = table(name("Personaje"));
        Field[] columnas = tablaPersonaje.fields("clase","nombrePersonaje","raza","subRaza","alineamiento",
                "trasfondo","equipo","rasgo","arquetipo");
        query.insertInto(tablaPersonaje, columnas[0], columnas[1],columnas[2], columnas[3],columnas[4],
                columnas[5],columnas[6],columnas[7],columnas[8]).values(personaje.getClase(),
                personaje.getNombrePersonaje(),personaje.getRaza(),personaje.getSubRaza(),
                personaje.getAlineamiento(),personaje.getTrasfondo(),personaje.getEquipo(),
                personaje.getRasgo(),personaje.getArquetipo()).execute();
    }
    //----------------------------------------------------------------------------------------------------------------------
    public static void modificarPersonaje(String nombrePersonaje, String columnaTabla, Object dato){
        query.update(DSL.table("Personaje")).set(DSL.field(columnaTabla),dato).
                where(DSL.field("nombrePersonaje").eq(nombrePersonaje)).execute();
    }
    public static List obtenerPersonaje(DSLContext query, String columnaTabla, Object dato) {
        Result resultados = query.select().from(DSL.table("Personaje")).where(DSL.field(columnaTabla).eq(dato)).fetch();
        return obtenerListaPersonajes(resultados);
    }
    public static List obtenerPersonajes(DSLContext query){
        Result resultados = query.select().from(DSL.table("Personaje")).fetch();
        return obtenerListaPersonajes(resultados);
    }




    public void eliminarPersonaje(DSLContext query, String nombrePersonaje){
        Table tablaPersonaje= DSL.table(name("Personaje"));
        query.delete(DSL.table("Personaje")).where(DSL.field("nombrePersonaje").eq(nombrePersonaje)).execute();
    }

    public static List obtenerListaPersonajes(DSLContext query, String nombre, String nombrePersonaje) {
        return null;
    }
    private static List obtenerListaPersonajes(Result resultados){
        List<Personaje> personajes= new ArrayList<>();
        for(int fila=0; fila<resultados.size();fila++){
            String clase = (String) resultados.getValue(fila,"clase");
            String nombrePersonaje = (String) resultados.getValue(fila,"nombrePersonaje");
            String raza = (String) resultados.getValue(fila,"raza");
            String subraza = (String) resultados.getValue(fila,"subRaza");
            String alineamiento = (String) resultados.getValue(fila,"alineamiento");
            String trasfondo = (String) resultados.getValue(fila,"trasfondo");
            String equipo = (String) resultados.getValue(fila,"equipo");
            String razgo = (String) resultados.getValue(fila,"razgo");
            String arquetipo = (String) resultados.getValue(fila,"arquetipo");
            personajes.add(new Personaje(clase,nombrePersonaje,raza,subraza,alineamiento,trasfondo,equipo,razgo,arquetipo));
        }
        return personajes;
    }

}
