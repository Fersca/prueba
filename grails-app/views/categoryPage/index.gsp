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
	<title>${catego.name}</title>
	<!-- Chico-UI Core Style Sheet -->	
	<link rel="stylesheet" type="text/css" href="${resource(dir:'src/ml/css',file:'chico-0.7.4-1.css')}">

	<!--[if lt IE 7 ]>
		<script src="./libs/js/dd_belatedpng.js"></script>
		<script> DD_belatedPNG.fix('img, .ico'); //fix any <img> or .ico background-images </script>
	<![endif]--> 
<head>
<body>
	
	<table class="datagrid" summary="Comentarios">
		<tr>
		<td>
			<a href="${createLink(controller: 'home', action:'index')}">
			<img src="${resource(dir:'images',file:'gExchangeLogo2.jpg')}" alt="Game Exchange" border="0" height="60" width="85"/>
			</a>
		</td>
		<td><h1>Bienvenido a GameExchange - La red social de gamers!</h1>
		</td>
		</tr>
	</table>		
	
	<div class="box">
	<table class="datagrid" summary="Descripcion">
			<tr>
				<td><h2>Nombre</h2></td><td>${catego.name}</td>
			</tr>		
			<tr>
				<td><h2>Descripci&oacute;n</h2></td><td>${catego.description}</td>
			</tr>	
	</table>
	</div>	

	<div class="box">
	<table class="datagrid" summary="Lista de Juegos">
	
				<g:each in="${juegos}">
				
					<tr>
						<td>
							<a href="${it.permalink()}">
							<img src="${it.icon}" height="74" width="50">
						</td>
						<td>
							<h2>${it.name}</h2>
						</td>
						<td>
							<h4>${it.description}</h4>
						</td>
						<td>
							${it.publisher}
						</td>
						<td>
							<h1>${it.pageRating}</h1>
						</td>
					</tr>		
				</g:each>		
				
	</table>
	</div>	

	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="${resource(dir:'src/js',file:'chico-0.7.4-1.js')}"></script>
	<script>

	</script> 

</body>
</html>