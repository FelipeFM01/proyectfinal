package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import modelo.Usuario;
import modelo.data.DBGenerator;
import modelo.data.dao.UsuarioDAO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "listaUsuarioServlet", value = "/listaUsuarios")
public class ListaUsuarioServlet extends HttpServlet {
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
            req.setAttribute("usuarios",agregarUsuariosEjemplo());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        RequestDispatcher respuesta = req.getRequestDispatcher("/listaUsuarios.jsp");
        respuesta.forward(req,resp);
    }


    private List agregarUsuariosEjemplo() throws ClassNotFoundException {

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Juan Perez", "EL Chango Alcachofa", "gg1234" ,"juan.p@mail.cl"));
        usuarios = UsuarioDAO.obtenerUsuarios(DBGenerator.conectarBD("ProyectAlphaBD"));
        return usuarios;
    }
}
