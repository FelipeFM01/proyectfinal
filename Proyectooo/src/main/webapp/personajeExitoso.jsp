
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

                                        <!-- Clase jsp GUÍA--->



    <title>ProyectAlpha</title><link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body style="background: url(images2/option2.jpg)" height=100% width=100% position:absolute >

<h1 class="encabezado" style="color: azure">Registro de Personaje a sido Exitoso</h1>

<div class="centrado">
    <form action="personajeExitoso" method="post">
        <label class="campoTexto"> Clase : <c:out value="${personaje.getClase()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Nombre de Personaje : <c:out value="${personaje.getNombrePersonaje()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Raza : <c:out value="${personaje.getRaza()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> SubRaza : <c:out value="${personaje.getSubRaza()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Alineamiento : <c:out value="${personaje.getAlineamiento()}"></c:out> </label>
        <br>
        <label class="campoTexto"> Trasfondo : <c:out value="${personaje.getTrasfondo()}"></c:out> </label>
        <br>
        <label class="campoTexto"> Equipo : <c:out value="${personaje.getEquipo()}"></c:out> </label>
        <br>
        <label class="campoTexto"> Rasgo : <c:out value="${personaje.getRasgo()}"></c:out> </label>
        <br>
        <label class="campoTexto"> Arquetipo : <c:out value="${personaje.getArquetipo()}"></c:out> </label>
        <br>
        <input class="boton" type="submit" value="enviar" >
    </form>
    <a class="boton"  style="color: azure" href=/Proyectooo_war_exploded/>Volver</a>
</div>


</body>
</html>
