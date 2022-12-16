<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ProyectAlpha</title>
    <link rel="stylesheet" href="estilos.css">
</head>

<body >
<div class="contenido" background=false>
    <nav  style="text-decoration-color: azure">
        <ul class="menu-horizontal">



            <form action="usuario" method="get">
                <li>
                    <a href="usuario.jsp" class="subtitulo" style="background-color: azure">Registro Usuario</a>
                </li>
            </form>

            <form action="/personaje"  method="get">
                <li>
                    <a href="#" class="subtitulo" style="background-color: azure">Crear personaje</a>
                    <ul class="menu-vertical">
                        <li><a href="barbaro.jsp">Bárbaro</a></li>
                        <li><a href="bardo.jsp">Bardo</a></li>
                        <li><a href="brujo.jsp">Brujo</a></li>
                        <li><a href="clerigo.jsp">Clérigo</a></li>
                        <li><a href="druida.jsp">Druida</a></li>
                        <li><a href="guerrero.jsp">Guerrero</a></li>
                        <li><a href="hechicero.jsp">Hechicero</a></li>
                        <li><a href="mago.jsp">Mago</a></li>
                        <li><a href="monje.jsp">Monje</a></li>
                        <li><a href="paladin.jsp">Paladin</a></li>
                        <li><a href="picaro.jsp">Pícaro</a></li>
                        <li><a href="ranger.jsp">Ranger</a></li>
                    </ul>



                </li>
            </form>
            <form action="/tablaPersonajes" method="get">
                <li>
                    <a href="listaPersonajes.jsp" class="subtitulo" style="background-color: azure">Personajes</a>
                </li>
            </form>
            <form action="/tablaUsuarios" method="get">
                <li>
                    <a href="listaUsuarios.jsp" class="subtitulo" style="background-color: azure">Usuarios</a>
                </li>
            </form>

        </ul>
    </nav>


</div>

</body>
</html>