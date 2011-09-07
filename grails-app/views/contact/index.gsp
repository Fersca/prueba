<!doctype html>
<!--[if IE]><![endif]-->
<!--[if lt IE 7 ]> <html lang="es" class="no-js ie6"> <![endif]--> 
<!--[if IE 7 ]>    <html lang="es" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="es" class="no-js ie8"> <![endif]--> 
<!--[if IE 9 ]>    <html lang="es" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="es" class="no-js"> <!--<![endif]-->
<head>
	<!-- Avoid script blocking -->
	<script></script>
	<meta charset="utf-8">
	<title>Game Exchange</title>
	<!-- Chico-UI Core Style Sheet -->	
	<link rel="stylesheet" type="text/css" href="${resource(dir:'src/ml/css',file:'chico-0.7.4-1.css')}">

	<!--[if lt IE 7 ]>
		<script src="./libs/js/dd_belatedpng.js"></script>
		<script> DD_belatedPNG.fix('img, .ico'); //fix any <img> or .ico background-images </script>
	<![endif]--> 
<head>
<body>

	<form action="${createLink(controller: 'contact', action:'contactar',id: destino)}" id="demoform" method="post">
		<fieldset>
			<legend>Contactar al Gamer</legend>
			<ol>			
				<li class="fieldBox">
					<label class="required" for="subject">
						<span>Encabezado</span>
						<input type="text" value="" id="subject" required="required" name="subject">
					</label>
					<p class="help">Escribe el mensaje para el Gamer</p>
				</li>		
				<li class="fieldbox">
					<label class="required" for="mensaje">
						<span>Mensaje</span>
						<textarea name="mensaje" required="required"></textarea>
					</label>
					<p class="help">Escribe el mensaje para el Gamer</p>
				</li>									
			</ol>
		</fieldset>
		<p class="actions">
			<input type="submit" value="Enviar" class="btn primary">
			<a href="#" class="resetForm">Cancelar</a>
		</p>
	</form>
		
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="${resource(dir:'src/js',file:'chico-0.7.4-1.js')}"></script>
	<script>

	</script> 
</body>
</html>