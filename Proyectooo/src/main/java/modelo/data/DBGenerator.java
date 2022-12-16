package modelo.data;

import org.jooq.DSLContext;
import org.jooq.DataType;
import org.jooq.impl.DSL;

import java.sql.Connection;

import static org.jooq.impl.DSL.foreignKey;
import static org.jooq.impl.DSL.primaryKey;
import static org.jooq.impl.SQLDataType.VARCHAR;

public class DBGenerator {
    //Metodo inicial para crear una base de datos y sus respectivas tablas en caso de que no exista
    public static void iniciarBD(String nombreBD) throws ClassNotFoundException {
        Connection connection = DBConnector.connection("root", "");
        DSLContext create = DSL.using(connection);
        crearBaseDato(create,nombreBD);
        create = actualizarConexion(connection,nombreBD);
        crearTablaUsuario(create);
        crearTablaPersonaje(create);
        relacionarTabla(create,"CrearUsuario","nombrePersonaje","NombrePersonaje");
        DBConnector.closeConnection();
    }

    //Metodo para conectarse a una base de datos ya creada
    public static DSLContext conectarBD(String nombre) throws ClassNotFoundException {
        Connection connection = DBConnector.connection(nombre,"root","");
        DSLContext create = DSL.using(connection);
        return create;
    }
    //Crea una base de datos en caso de que no exista
    private static void crearBaseDato(DSLContext create, String nombreBD){
        create.createDatabaseIfNotExists(nombreBD).execute();
    }
    //Actualiza la conexion inicial para conectar a la base de datos
    private static DSLContext actualizarConexion(Connection connection, String nombreBD){
        DBConnector.closeConnection();
        connection= DBConnector.connection(nombreBD,"root","");
        DSLContext create=DSL.using(connection);
        return create;
    }

    private static void crearTablaUsuario(DSLContext create){
        create.createTableIfNotExists("CrearUsuario").column("nombre",VARCHAR(50))
                .column("nombrePersonaje",VARCHAR(50))
                .column("contraseña",VARCHAR(20))
                .column("correo",VARCHAR(20))
                .constraint(primaryKey("nombrePersonaje")).execute();
        
    }       //hacer restriccion para nombre único de usuario
    private static void crearTablaPersonaje(DSLContext create){
        create.createTableIfNotExists("CrearPersonaje").column("clase",VARCHAR(9))
                .column("NombrePersonaje",VARCHAR(50))
                .column("Raza",VARCHAR(20))
                .column("Sub-raza",VARCHAR(50))
                .column("Alineamiento",VARCHAR(50))
                .column("Trasfondo",VARCHAR(50))
                .column("Equipo",VARCHAR(50))
                .column("Rasgo",VARCHAR(50))
                .column("Arquetipo",VARCHAR(50))
                .constraint(primaryKey("NombrePersonaje")).execute();
    }

    private static void relacionarTabla(DSLContext create, String nombreTabla, String claveForanea, String nombreTablaRelacion){
        //  create.alterTableIfExists(nombreTabla).add(foreignKey(claveForanea).references(nombreTablaRelacion)).execute();
        create.alterTableIfExists(nombreTabla).alterConstraint(foreignKey(claveForanea).references(nombreTablaRelacion)).enforced();
    }
    private static void agregarColumnaTabla(DSLContext create, String nombreTabla, String columna, DataType tipoColumna){
        create.alterTableIfExists(nombreTabla).addColumn(columna,tipoColumna);
    }

}
