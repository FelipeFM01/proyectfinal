
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProyectAlpha</title><link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body style="background: url(images2/PrtScrCapture_2.jpg)" height=100% width=100% position:absolute >

<h1 class="encabezado" style="color: azure">Registro de Clérigo</h1>

<div class="centrado">
    <form action="clerigo" method="post">
        <label class="campoTexto"> Clase : <input type="text" name="clase"/><c:out value="${personaje.getClase()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Nombre de Personaje : <input type="text" name="nombrePersonaje"/><c:out value="${personaje.getNombrePersonaje()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Raza : <input type="text" name="raza"/><c:out value="${personaje.getRaza()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> SubRaza : <input type="text" name="subRaza"/><c:out value="${personaje.getSubRaza()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Alineamiento : <input type="text" name="alineamiento"/><c:out value="${personaje.getAlineamiento()}"></c:out> </label>
        <br>
        <label class="campoTexto"> Trasfondo : <input type="text" name="trasfondo"/><c:out value="${personaje.getTrasfondo()}"></c:out> </label>
        <br>
        <label class="campoTexto"> Equipo : <input type="text" name="equipo"/><c:out value="${personaje.getEquipo()}"></c:out> </label>
        <br>
        <label class="campoTexto"> Rasgo : <input type="text" name="rasgo"/><c:out value="${personaje.getRasgo()}"></c:out> </label>
        <br>
        <label class="campoTexto"> Arquetipo : <input type="text" name="arquetipo"/><c:out value="${personaje.getArquetipo()}"></c:out> </label>
        <br>
        <input class="boton" type="submit" value="enviar" >
    </form>
    <font color="yellow" >
    <p>Para mas informacion puede guiarse por el siguiente link, pagina 47</p></font>
    <a style="color: yellow" href="http://huertadesolymar.uy/D&D5Manual.pdf">Manual de Jugador D&D 5ta edicion</a>
    <br>
    <br>
    <br>


    <a class="boton"  style="color: azure" href=/Proyectooo_war_exploded/>Volver</a>
</div>


</body>
</html>
