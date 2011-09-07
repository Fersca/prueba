package pse.web

import pse.Message;
import pse.User;

class ContactController {

    def index = { 
		
		if (session.user){
			[destino: params.id]
		} else {
			render "Tienen que estar logueado para contactar"
		}
			
	}

	def iframe = {
		
		[destino: params.id]
			
	}
		
	def contactar = {
		
		User usu = User.get(params.id)
		
		if (usu){
			Message me = new Message()

			me.subject = params.subject
			me.fromUser = session.user
			me.toUser = usu
			me.text = params.mensaje
			me.createdDate = new Date()
			me.readByReceiver=false
			if (me.save(flush:true)){
				render "Mensaje enviado correctamente"
			} else {
				render me.errors
			}

		} else {
			render "Error contactando usuario"
		}
		
	}
}
