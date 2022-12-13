
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ProyectAlpha</title>
</head>
<body style="background: url(images2/PrtScrCapture_6.jpg)" height=100% width=100% position:absolute >

<h1 class="encabezado"> Registro Usuario</h1>
<h2 class="subtitulo"> El Registro posee datos erroneos o NO a completado todos los campos, favor complete nuevamente </h2>

<div class="centrado">
    <form action="usuarioErroneo" method="post">

        <label class="campoTexto"> Nombre : <input type="text" name="nombre"/> </label>
        <br>
        <br>
        <label class="campoTexto"> Nombre de Personaje : <input type="text" name="nombrePersonaje"/> </label>
        <br>
        <br>
        <label class="campoTexto"> Correo : <input type="text" name="correo"/> </label>
        <br>
        <br>
        <label class="campoTexto"> Contraseña : <input type="text" name="contraseña"/> </label>
        <br>
        <br>
        <input class="boton" type="submit" value="enviar" >
    </form>
    <a class="boton" href=/Proyectooo_war_exploded/>Volver</a>

</div>


</body>
</html>
