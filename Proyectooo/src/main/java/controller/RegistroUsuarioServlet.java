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
import org.jooq.DSLContext;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "registroUsuarioServlet", value = "/usuario")
public class RegistroUsuarioServlet extends HttpServlet {
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
        //La respuesta que le vamos a devolver, va a ser la dirección del archivo JSP usuario.jsp
        RequestDispatcher respuesta = req.getRequestDispatcher("/usuario.jsp");
        //envía la respuesta
        respuesta.forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
        RequestDispatcher respuesta = req.getRequestDispatcher("/usuarioErroneo.jsp");
        if(req.getParameter("nombre").length()!=0 && req.getParameter("nombrePersonaje").length()!=0
                && req.getParameter("contraseña").length()!=0 && req.getParameter("correo").length()!=0){

            String nombre = req.getParameter("nombre");
            String nombrePersonaje = req.getParameter("nombrePersonaje");
            String contraseña = req.getParameter("contraseña");
            String correo = req.getParameter("correo");
            Usuario usuario = new Usuario(nombre, nombrePersonaje, contraseña, correo);
            try {
                if(agregarUsuario(usuario)){
                    req.setAttribute("usuario",usuario);
                    respuesta = req.getRequestDispatcher("/usuarioExitoso.jsp");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        respuesta.forward(req,resp);
    }

    private static boolean agregarUsuario(Usuario usuario) throws ClassNotFoundException {
        DSLContext query= DBGenerator.conectarBD("ProyectAlphaBD");
        List<Usuario> usuarios= UsuarioDAO.obtenerUsuario(query,"nombrePersonaje", usuario.getNombrePersonaje());
        if(usuarios.size()!=0){
            return false;
        }
        else{
            UsuarioDAO.agregarUsuario(query,usuario);
            return true;
        }
    }

}

