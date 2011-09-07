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
	<title>${ga.name}</title>
	<!-- Chico-UI Core Style Sheet -->	
	<link rel="stylesheet" type="text/css" href="${resource(dir:'src/ml/css',file:'chico-0.7.4-1.css')}">
	<link rel="stylesheet" type="text/css" href="${resource(dir:'src/ml/css',file:'chico-mesh.css')}">
	
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
			<img src="${resource(dir:'images',file:'gExchangeLogo2.jpg')}" alt="Game Exchange" border="0" height="121" width="173"/>
			</a>
		</td>
		<td><h1>Bienvenido a GameExchange - La red social de gamers!</h1>
		</td>
		</tr>
	</table>		
	
	<div class="box">
	<table class="datagrid" summary="Descripcion">
			<tr>
				<td><h3>Juego</h3></td><td>${ga.name}</td>
			</tr>
			<tr>
				<td><h3>Categor&iacute;a</h3></td>
				<td>
				<a href="${ga.category.permalink()}">${ga.category.name}</a>				
				</td>
			</tr>		
			<tr>
				<td><h3>Descripci&oacute;n</h3></td><td>${ga.description}</td>
			</tr>		
			<tr>
				<td><h3>Fabricante</h3></td><td>${ga.publisher}</td>
			</tr>		
			<tr>
				<td><h3>Jugadores</h3></td><td>${ga.players}</td>
			</tr>		
			<tr>
				<td><h3>Puntaje de la P&aacute;gina</h3></td><td>${ga.pageRating}</td>
			</tr>		
			<tr>
				<td><h3>Rating ESRB</h3></td><td><span class="YOUR_SELECTOR_LayerOnmouseover ch-left ch-bottom" style="cursor: default;"><font color="red">${ga.esrb}</font></span></td>				
			</tr>		
			<tr>
				<td><h3>Fecha de Lanzamiento</h3></td><td>${ga.releaseDate}</td>
			</tr>		
			
	</table>
	</div>	
	
	<div class="box">	
		<div id="rew_example">
			<h4>Review</h4>
			<div>
				<p>${ga.review}</p>
			</div>
		</div>
	</div>

	<div class="ch-g1-2">

	    <div class="box leftcolumn">
			<h2>Imagen del Juego</h2>
	    	<center>
			<g:each in="${ga.images}">
					<img src="${it.fileName}" height="452" width="320">
			</g:each>
			</center>
	    </div>
	</div>
	
	<div class="ch-g1-2">
		
	    <div class="box rightcolumn">
	    	<h2>Video del Juego</h2>
				<g:each in="${ga.videos}">
					${it.link}
				</g:each>
	    </div>
	</div>	


	<div class="box">
		<table class="datagrid" summary="Comentarios">
			<caption>Comentarios del Juego</caption>
			<thead>
				<tr>
					<th scope="col">Comentarios</th>
					<th scope="col">Usuario</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${ga.comments}">
					<tr>
						<td>
							${it.text}
						</td>
						<td>
							<a href="${it.user.permalink()}">
							${it.user.getNick()}
							</a>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>

	<div class="box">
		<table class="datagrid" summary="Puntaje">
			<caption>Puntajes del Juego</caption>
			<thead>
				<tr>
					<th scope="col">Puntaje</th>
					<th scope="col">Usuario</th>
				</tr>
			</thead>
			<tbody>
				<g:each in="${ga.points}">
					<tr>
						<td>
							${it.points}
						</td>
						<td>
							<a href="${it.user.permalink()}">
							${it.user.getNick()}
							</a>
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>

	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="${resource(dir:'src/js',file:'chico-0.7.4-1.js')}"></script>
	<script>

	var foo = $("#rew_example").expando({open:true});

	// Layer on mouseover
	var ch_layr = $(".YOUR_SELECTOR_LayerOnmouseover").layer("<p>${ga.esrb.description}</p>");

	</script> 

</body>
</html>