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
	<title>${usua.getNick()}</title>
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
				<td><h2>Avatar</h2></td>
				<td>
					<img src="${resource(dir:'images/avatars',file:usua.avatar)}" />
				</td>
			</tr>		
			<tr>
				<td><h2>Nickname</h2></td>
				<td>
					<table>
						<tr>
							<td>
							 <img src="${resource(dir:'images/flags',file:usua.country.flag)}"/> ${usua.getNick()}
							</td>
							<td>
								<form action="${createLink(controller: 'contact', action:'iframe', id:usua.id )}">
								<p class="actions">
								<input class="btn secondary YOUR_SELECTOR_Modal" type="submit" value="Contactar al Gamer" style="cursor: pointer;">
								</p>
								</form>											
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td><h2>Nombre Completo</h2></td><td>${usua.realName}</td>
			</tr>		
			<tr>
				<td><h2>PSN Alias</h2></td><td>${usua.psnAlias}</td>
			</tr>	
			<tr>
				<td><h2>Plataforma Favorita</h2></td><td>${usua.favoritePlataform}</td>
			</tr>		
			<tr>
				<td><h2>Pa&iacute;s</h2></td><td>${usua.country}</td>
			</tr>						
	</table>
	</div>	
	
	<div class="box">
		<table class="datagrid" summary="Juegos">
			<caption>Juegos que posee</caption>
			<thead>
				<tr>
					<th scope="col">Juego</th>					
					<th scope="col">Vende</th>
					<th scope="col">Precio</th>
					<th scope="col">Intercambia</th>
				</tr>
			</thead>
			
			<tbody>
				<g:each in="${usua.adquisitions}">
					<tr>
						<td>
							<a href="${it.gameObject.permalink()}">
							${it.gameObject}
							</a>
						</td>
						<td>
							${it.availableSelling}
						</td>
						<td>
							${it.price}
						</td>
						<td>
							${it.availableExchange}
						</td>
					</tr>
				</g:each>
			</tbody>
		</table>
	</div>

	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="${resource(dir:'src/js',file:'chico-0.7.4-1.js')}"></script>
	<script>

	// Modal
	var ch_moda = $(".YOUR_SELECTOR_Modal").modal({
		width: "600px",
		height: "320px"
	});
	
	</script> 

</body>
</html>