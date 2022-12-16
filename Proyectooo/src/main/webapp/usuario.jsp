
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProyectAlpha</title>
    <link rel="stylesheet" type="text/css" href="estilos.css">
</head>
<body style="background: url(images2/PrtScrCapture_6.jpg)" height=100% width=100% position:absolute >
<h1 class="encabezado" style="color: azure">Registro Usuario</h1>

<div class="centrado">
<form action="usuario" method="get">
    <label class="campoTexto"> Nombre : <input type="text" name="nombre"/><c:out value="${usuario.getNombre()}"></c:out> </label>
    <br>
    <br>
    <label class="campoTexto"> Nombre de Personaje : <input type="text" name="nombrePersonaje"/><c:out value="${usuario.getNombrePersonaje()}"></c:out> </label>
    <br>
    <br>
    <label class="campoTexto"> Correo : <input type="text" name="correo"/><c:out value="${usuario.getcorreo()}"></c:out> </label>
    <br>
    <br>
    <label class="campoTexto"> Contraseña : <input type="text" name="contraseña"/><c:out value="${usuario.getconstraseña()}"></c:out> </label>
    <br>
    <br>
    <input class="boton" type="submit" value="enviar" >
</form>
    <a class="boton"  style="color: azure" href=/Proyectooo_war_exploded/>Volver</a>
</div>
</body>
</html>
