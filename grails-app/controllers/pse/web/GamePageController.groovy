package pse.web

import pse.GameObject;

class GamePageController {

    def index = { 
	
		GameObject game = GameObject.get(params.id)
		if (game){
			[ga: game]
		} else { 
			render "Juego no encontrado"
		}
		 	
	}
}
