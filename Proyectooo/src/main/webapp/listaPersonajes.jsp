
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProyectAlpha</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body style="background: url(images2/option2.jpg)" height=100% width=100% position:absolute >

<h1 class="encabezado" style="color: azure" >Personajes ingresados</h1>

<div class="centrado">
    <form action="mostrarPersonajes" method="post">
        <table style="color: azure" >
            <tr>
                <th>Clase</th>
                <br>
                <th>Nombre Personaje</th>
                <br>
                <th>Raza</th>
                <br>
                <th>SubRaza</th>
                <br>
                <th>Alineamiento</th>
                <br>
                <th>Trasfondo</th>
                <br>
                <th>Equipo</th>
                <br>
                <th>Rasgo</th>
                <br>
                <th>Arquetipo</th>
            </tr>
            <c:forEach items="${personajes}" var="personaje">
                <tr>
                    <td><c:out value="${personaje.getClase()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${personaje.getNombrePersonaje()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${personaje.getRaza()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${personaje.getSubRaza()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${personaje.getAlineamiento()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${personaje.getTrasfondo()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${personaje.getEquipo()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${personaje.getRasgo()}"></c:out> </td>
                    <br>
                    <td> <c:out value="${personaje.getArquetipo()}"></c:out> </td>
                </tr>
            </c:forEach>

        </table>

    </form>
    <a class="boton"  style="color: azure" href=/Proyectooo_war_exploded/>Volver</a>

</div>


</body>
</html>
