package pse.web

import pse.User;

class LoginController {

    def index = { }
	
	def logOut = {
		session.user=null
		chain(controller: 'home', action: 'index')
	}
	
	def login = {
		
		def user = params.user
		def pass = params.password
		
		if (!user || !pass){
			render "Ingrese valores correctos para nickname y password"
			return
		}
		
		user = user.toLowerCase()
		
		User usu = User.findByNickname(user)
		if (usu && usu.password==pass){
			session.user=usu
			chain(controller: 'home', action: 'index')
			return
		} 
		
		usu = User.findByEmail(user)
		if (usu && usu.password==pass){
			session.user=usu
			chain(controller: 'home', action: 'index')
			return
		}

		render "Invalid user Password"
		return

	}
}

