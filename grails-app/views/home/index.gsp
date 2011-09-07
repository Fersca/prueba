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
	<link rel="stylesheet" type="text/css" href="${resource(dir:'src/ml/css',file:'chico-mesh.css')}">

	<!--[if lt IE 7 ]>
		<script src="./libs/js/dd_belatedpng.js"></script>
		<script> DD_belatedPNG.fix('img, .ico'); //fix any <img> or .ico background-images </script>
	<![endif]--> 
<head>
<body>

	<div class="ch-g1-4">
	
	     <div class="box leftcolumn">
	    	<div class="container">	
	    	<ul>
	    		<li><h3>Categor&iacute;as</h3></li>
	    	</ul>    
	    	<ul id="example">				
				<g:each in="${maincategs}">
					<li>
					<span>${it.name}</span>
					<ul>
						<g:each in="${it.categories}">		
							<li><a href="${it.permalink()}">${it.name} (${it.games.size()})</a></li>
						</g:each>																	
					</ul>
					</li>					
				</g:each>	
	    	</ul>
			<ul>
				<br><li><h3>Plataformas</h3></li>
				<g:each in="${platforms}">		
					<li><a href="#">${it.name}</a></li>
				</g:each>											
			</ul>
			<ul>
				<br><li><h3>Pa&iacute;ses</h3></li>					
				<g:each in="${countries}">		
					<li>
					<a href="#">
					<img src="${resource(dir:'images/flags',file:it.flag)}"/>
					${it.name} (${it.cant})					
					</a>
					</li>
				</g:each>											
			</ul>							    
			</div>					
	    </div>	
	
	
	</div>
	<div class="ch-g2-4">
	    <div class="box centercolumn">
		<center>
			<img src="${resource(dir:'images',file:'gExchangeLogo2.jpg')}" alt="Game Exchange" border="0" height="182" width="260"/>
			<h2>
				Bienvenido a GameExchange<br>
				La red social de gamers
			</h2>						
		</center>
	    </div>

		<div class="box centercolumn">
			<form action="${createLink(controller: 'listado', action:'index')}" id="searchform" name="searchform">
				<input type="text" size="55" name="palabra" id="palabra">
				<input type="button" value="Buscar" class="btn secondary" onclick="verify();">
			</form>
		</div>

		<div class="box centercolumn">
			<h2>Game Exchange</h2>
			<p>
			Game Exchange es la primera red social de Gamers de Latinoam&eacute;rica
			Game Exchange te permite intercambiar juegos con otros Gamers de toda la regi&oacute;n, brindar comentarios y reviews a tus juegos favoritos y recomandar amigos.
			</p>
		</div>	    
		
		<div class="box centercolumn">
			<div class="examplecarru ch-carousel">
				<h2>Juegos Recomendados</h2>
				<ul>				
					<g:each in="${topGames}">		
						<li>
						<a href="${it.permalink()}">
						<img src="${it.icon}">
						</a>
						</li>
					</g:each>									
				</ul>			
			</div>			
		</div>
	</div>
	<div class="ch-g1-4">
	    <div class="box rightcolumn">
	
			<g:if test="${session.user!=null}">
			    Usuario: <a href="${createLink(controller: 'userPage', action:'index', id:session.user.id )}">${session.user.getNick()}</a>
			    <g:if test="${session.user.facebookUserId}">
			    	<img src="https://graph.facebook.com/${session.user.facebookUserId}/picture"/>
			    </g:if>		
			    <a href="${createLink(controller: 'login', action:'logOut')}">LogOut</a>	    			    			   
			</g:if>
			<g:else>			
				<a href="${createLink(controller: 'login', action:'index')}">Login</a>				
				<a onclick="window.open(this.href, this.target,'status=0,scrollbars=0,width=626, height=436'); return false;" target="_blank" href="http://www.facebook.com/dialog/oauth/?scope=email&client_id=191003690969930&redirect_uri=http%3A%2F%2Fec2-174-129-96-72.compute-1.amazonaws.com%2FPSE-0.1%2Fregister%2Flogin&response_type=code&display=popup">Ingresar con Facebook</a>				
			</g:else>
					
	    </div>

	    <div class="box rightcolumn">
	
				<table class="datagrid" summary="Mejores Juegos">
					<caption>Mejores Juegos</caption>
					<thead>
						<tr>
							<th scope="col">Juego</th>
							<th scope="col">Rating</th>
							<th scope="col">Votos</th>
						</tr>
					</thead>	
					<g:each in="${topGames}">		
						<tr class="selected">
							<td>
								<a href="${it.permalink()}">
								${it.name}
								</a>
							</td>
							<td>${it.points}</td><td>${it.cant}</td>
						</tr>
					</g:each>		
				</table>
				
				<table class="datagrid" summary="Mejores Gamers">
					<caption>Gamers con Mayor Actividad</caption>
					<thead>
						<tr>
							<th scope="col">Nickname</th>
							<th scope="col">Puntos</th>
						</tr>
					</thead>
					<g:each in="${topUsers}">		
						<tr class="selected">
							<td>
							<a href="${it.permalink()}">
							 <img src="${resource(dir:'images/flags',file:it.flag)}"/> ${it.nick}
							</a>
							</td>
							<td>${it.points}</td>
						</tr>
					</g:each>		
				</table>
				
	    </div>	  
	    
	    <div class="box rightcolumn">
			<h2>Buscador de Juegos</h2>
			<ul id="example">
			
				<g:each in="${maincategs}">
					<li>
					<span>${it.name}</span>
					<ul>
						<g:each in="${it.categories}">		
							<li><a href="#">${it.name}</a></li>
						</g:each>																	
					</ul>
					</li>					
				</g:each>	
			
			
			
				<li>
					<span>Categor&iacute;as</span>
					<ul>
						<g:each in="${categories}">		
							<li><a href="#">${it.name}</a></li>
						</g:each>											
					</ul>
				</li>
				<li>
					<span>Plataformas</span>
					<ul>
						<g:each in="${platforms}">		
							<li><a href="#">${it.name}</a></li>
						</g:each>											
					</ul>
				</li>
				<li>
					<span>Pa&iacute;ses</span>
					<ul>
						<g:each in="${countries}">		
							<li><a href="#">${it.name}</a></li>
						</g:each>											
					</ul>
				</li>
				<li>
					<a href="#">Tools</a>
				</li>
			</ul>
	
	    </div>
	    
	</div>
		
	<div class="ch-g1">
	    <div class="box">
	        Game Exchange es la red social de Gamer en Latinoam&eacute;rica.
	    </div>
	</div>
		
	
	<script src="http://code.jquery.com/jquery.min.js"></script>
	<script src="${resource(dir:'src/js',file:'chico-0.7.4-1.js')}"></script>
	<script src="http://connect.facebook.net/es_LA/all.js"></script>
	<script>
	
	var foo = $("#example").menu({seleted:1});

	var foo = $(".examplecarru").carousel();

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