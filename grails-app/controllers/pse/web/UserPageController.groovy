package pse.web

import pse.User;

class UserPageController {

    def index = { 
	
		User usu = User.get(params.id)
		if (usu){
			[usua: usu]
		} else {
			render "Usuario no encontrado"
		}
		
	}
}
