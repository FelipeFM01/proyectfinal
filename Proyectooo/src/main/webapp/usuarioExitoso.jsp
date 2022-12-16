
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <link rel="stylesheet" type="text/css" href="estilos.css">

    <title>ProyectAlpha</title>
</head>
<body style="background: url(images2/PrtScrCapture_6.jpg)" height=100% width=100% position:absolute >
<h1 class="encabezado" style="color: azure"> Registro Usuario</h1>
<h2 class="subtitulo" style="color: azure">El Registro a sido Exitoso </h2>

<div class="centrado">
    <form action="usuarioExitoso" method="post">

        <label class="campoTexto"> Nombre : <c:out value="${usuario.getNombre()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Nombre de Personaje : <c:out value="${usuario.getNombrePersonaje()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Correo : <c:out value="${usuario.getcorreo()}"></c:out> </label>
        <br>
        <br>
        <label class="campoTexto"> Contraseña : <c:out value="${usuario.getconstraseña()}"></c:out> </label>
        <br>
        <br>
        <input class="boton" type="submit" value="enviar" >
    </form>
    <a class="boton"  style="color: azure" href=/Proyectooo_war_exploded/>Volver</a>
</div>


</body>
</html>
