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
	
	<div class="box centercolumn">
		<form action="${createLink(controller: 'listado', action:'index')}" id="searchform" name="searchform">
			<input type="text" size="55" name="palabra" id="palabra">
			<input type="button" value="Buscar" class="btn secondary" onclick="verify();">
		</form>
	</div>
	
	
	<div class="box">
	<table class="datagrid" summary="Lista de Juegos">
	
				<g:if test="${juegos.size==0}">
				    <tr>
			    		<td>
							<h2>No se ha encontrado ning&uacute;n juego</h2>
						</td>
				    </tr>			    
				</g:if>
				<g:else>
					<g:each in="${juegos}">
						<tr>
							<td>
								<a href="${it.permalink()}">
								<img src="${it.icon}">
							</td>
							<td>
								<h2>${it.name}</h2>
							</td>
							<td>
								${it.description}
							</td>
							<td>
								${it.publisher}
							</td>
							<td>
								${it.pageRating}
							</td>
						</tr>		
					</g:each>		
				</g:else>				
	</table>
	</div>	

	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="${resource(dir:'src/js',file:'chico-0.7.4-1.js')}"></script>
	<script>

	function verify() {
		if (document.searchform.palabra.value=="") {
			alert("Debe ingresar el nombre del juego");
			return false;
		} else {
			document.searchform.submit();
		}
	}
	
	</script> 

</body>
</html>