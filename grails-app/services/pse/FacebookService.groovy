package pse

import org.codehaus.groovy.grails.commons.ConfigurationHolder as CH

import grails.converters.*

class FacebookService {

    static transactional = false

    def getAccessToken(code) {
		
		String oauth = 'http://www.facebook.com/dialog/oauth/'
		String oauthAccessToken = 'https://graph.facebook.com/oauth/access_token'
		String redirectUri = 'http%3A%2F%2Fec2-174-129-96-72.compute-1.amazonaws.com%2FPSE-0.1%2Fregister%2Flogin'
		String clientId = '191003690969930'
		String clientSecret = 'd6a5fe6e37c3a590e7cd763adcb5d33f'
				
		String url = oauthAccessToken+"?client_id="+clientId+"&redirect_uri="+redirectUri+"&client_secret="+clientSecret+"&code="+code
		
		String body =  new URL(url).text
		
		def valores = body.split("&") 
		
		def accessTokenPart = valores[0].split("=") 
		
		return accessTokenPart[1]
		
		/*
		def map = [:]
		
		def value = body.tokenize('&').collect() {  value ->
		
		 def split = value.split('=');
		 map[(split[0])] = split[1].decodeURIComponent()
		
		}
		 
		return  map
		*/
    }
	
	def getUser(accessToken) {
		
		def body =  new URL("https://graph.facebook.com/me?access_token="+accessToken).text
		
		return JSON.parse(body)
		
	}
}
