package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Personaje;
import modelo.Usuario;
import modelo.data.DBGenerator;
import modelo.data.dao.PersonajeDAO;
import modelo.data.dao.UsuarioDAO;
import org.jooq.DSLContext;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static modelo.data.dao.PersonajeDAO.agregarPersonaje;

@WebServlet(name = "registroPersonajeServlet", value = "/personaje")
public class RegistroPersonajeServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("ProyectAlphaBD");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo de la clase JSP
        RequestDispatcher respuesta = req.getRequestDispatcher("personaje/.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/personajeErroneo.jsp");
        if(req.getParameter("clase").length()!=0 && req.getParameter("nombrePersonaje").length()!=0
                && req.getParameter("raza").length()!=0 && req.getParameter("subRaza").length()!=0 &&
                req.getParameter("alineamiento").length()!=0 && req.getParameter("trasfondo").length()!=0 &&
                req.getParameter("equipo").length()!=0 && req.getParameter("rasgo").length()!=0 &&
                req.getParameter("arquetipo").length()!=0){

            String clase = req.getParameter("clase");
            String nombrePersonaje = req.getParameter("nombrePersonaje");
            String raza = req.getParameter("raza");
            String subRaza = req.getParameter("subRaza");
            String alineamiento = req.getParameter("alineamiento");
            String trasfondo = req.getParameter("trasfondo");
            String equipo = req.getParameter("equipo");
            String rasgo = req.getParameter("rasgo");
            String arquetipo = req.getParameter("arquetipo");

            Personaje personaje = new Personaje(clase, nombrePersonaje, raza, subRaza, alineamiento, trasfondo, equipo,
                    rasgo, arquetipo);
            try{
                if(agregarPersonaje(personaje)){
                    req.setAttribute("personaje",personaje);
                    respuesta = req.getRequestDispatcher("/personajeExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private static boolean agregarPersonaje(Personaje personaje) throws ClassNotFoundException{
        DSLContext query= DBGenerator.conectarBD("ProyectAlphaBD");
        List<Personaje> personajes= PersonajeDAO.obtenerPersonaje(query,"nombrePersonaje", personaje.getNombrePersonaje());
        if(personajes.size()!=0){
            return false;
        }
        else{
            PersonajeDAO.agregarPersonaje(query,personaje);
            return true;
        }
    }



}