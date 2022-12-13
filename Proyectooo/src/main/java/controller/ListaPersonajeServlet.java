package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Personaje;
import modelo.data.DBGenerator;
import modelo.data.dao.PersonajeDAO;
import modelo.data.dao.UsuarioDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listaPersonajeServlet", value = "/listaPersonajes")
public class ListaPersonajeServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        try {
            DBGenerator.iniciarBD("ProyectAlphaBD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setAttribute("personajes",agregarPersonajesEjemplo());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/listaPersonajes.jsp");
        respuesta.forward(req,resp);
    }


    private List agregarPersonajesEjemplo() throws ClassNotFoundException {

        List<Personaje> personajes = new ArrayList<>();
        personajes.add(new Personaje("Ranger", "EL Chango Alcachofa", "Elfo" ,
                "Elfo de los Bosques", "Neutral Caótico", "...", "...", "...",
                "Explorador de ruinas, Enemigo de Golems"));
        personajes = PersonajeDAO.obtenerPersonajes(DBGenerator.conectarBD("ProyectAlphaBD"));


        return personajes;
    }

}

