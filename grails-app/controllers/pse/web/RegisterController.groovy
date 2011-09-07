package pse.web

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import pse.Country;
import pse.Plataform;
import pse.User;

import grails.converters.JSON

class RegisterController {

    def index = { 
		
	}
	
	def facebookService
	
	def login = {
		
		String accessToken =  facebookService.getAccessToken(params.code)
		
		def facebookUser = facebookService.getUser(accessToken)
		
		createUser(facebookUser)

		def html = '''
		<html>
		<head>
		</head>
		<body>
		<script type="text/javascript">
		self.close(); window.opener.location.href = window.opener.location.href;
		</script>
		</body>
		</html>		
		'''
				
		render html
				
	}
	
	def register = {
				
		String sigreq = params.signed_request
	
		int idx = sigreq.indexOf(".");
		byte[] sig = new Base64(true).decode(sigreq.substring(0, idx).getBytes());
		String rawpayload = sigreq.substring(idx+1);
		String payload = new String(new Base64(true).decode(rawpayload));
		
		def converter = new JSON()
		def json = JSON.parse(payload)
		
		/* check if it is HMAC-SHA256 */
		if (json.algorithm!="HMAC-SHA256") {

			throw new Exception("Unexpected hash algorithm");
		}
		
		//checkSignature(rawpayload, sig);
		
		createUser(json)
		
		chain(controller: 'home', action: 'index')
		
		/*
		if (json.registration){
			render json.registration.email
		} else {
			render json
		}
		*/
	}
	
	def createUser(def json){

		/*
		["hometown":["id":"", "name":null],
		"location":["id":"106423786059675", "name":"Buenos Aires, Argentina"],
		"link":"http://www.facebook.com/Fersca",
		"locale":"en_US",
		"updated_time":"2011-06-24T16:36:41+0000", 
		"id":"527564609",
		"first_name":"Fernando",
		"username":"Fersca",
		"timezone":-3,
		"email":"fersca@hotmail.com",
		"verified":true,
		"name":"Fernando Scasserra",
		"last_name":"Scasserra",
		"gender":"male"]
		*/
				
		User usu = User.findByFacebookUserId(json.id)
		
		if (usu){
			//verifica si el usuario tiene seteado el location, sino lo actualiza
			if (usu.locationCountry){				
			} else {
				if (json.location){
					
					Country country
					
					def location = json.location.name.split(",")
					
					usu.locationCity = location[0]
					usu.locationCountry = location[1].trim()
					usu.locationFbId= json.location.id
					
					country = Country.findByName(usu.locationCountry)
					
					if (country){
						usu.country = country
					} 
		
					usu.save(flush:true)
				}								
			}	
		} else {
			//Crea el usuario por primera vez
			usu = new User()
			usu.email = json.email.toLowerCase()
			usu.realName= json.name
			
			usu.password= "Hola"
			
			Country country
						
			if (json.location){
				
				def location = json.location.name.split(",")
				
				usu.locationCity = location[0]
				usu.locationCountry = location[1].trim()
				usu.locationFbId= json.location.id
				
				country = Country.findByName(usu.locationCountry)
				
			}
			
			if (country){
			} else {
				country = Country.findByName("Otro")
				if (country){
				} else {
					country = Country.get(1)
				}
			}
			
			usu.country = country
			
			usu.admin=false
			
			Plataform plataforma = Plataform.get(1)
	
			usu.favoritePlataform = plataforma
			usu.facebookUserId = json.id
			
			usu.save(flush:true)

		}

		session.user=usu

	}
	
	private void checkSignature(String rawpayload, byte[] sig) throws Exception {
		
		try {
			String secret = "d6a5fe6e37c3a590e7cd763adcb5d33f";
			
			SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HMAC-SHA256");
			Mac mac = Mac.getInstance("HMAC-SHA256");
			mac.init(secretKeySpec);
			byte[] mysig = mac.doFinal(rawpayload.getBytes());
			if (!Arrays.equals(mysig, sig)) {
				throw new Exception("Non-matching signature for request");
			}
		} catch (NoSuchAlgorithmException e) {
			throw new Exception("Unknown hash algorithm");
		} catch (InvalidKeyException e) {
			throw new Exception("Wrong key for");
		}
				
	}
	
}
