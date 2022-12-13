
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProyectAlpha</title>

    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>

<body style="background: url(images2/option2.jpg)" height=100% width=100% position:absolute >
<h1 class="encabezado">Usuarios ingresados</h1>

<div class="centrado">
    <form action="listaUsuarios" method="post">
        <table>
            <tr>
                <th>Nombre</th>
                <br>
                <th>Nombre Personaje</th>
                <br>
                <th>Contraseña</th>
                <br>
                <th>Correo</th>
            </tr>
            <c:forEach items="${usuarios}" var="usuario">
                <tr>
                    <td><c:out value="${usuario.getNombre()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${usuario.getNombrePersonaje()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${usuario.getContraseña()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${usuario.getCorreo()}"></c:out> </td>
                </tr>
            </c:forEach>


        </table>

    </form>
    <a class="boton" href=/Proyectooo_war_exploded/>Volver</a>

</div>

</body>
</html>
