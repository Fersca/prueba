package pse.web

import pse.Category;
import pse.GameObject;

class ListadoController {

    def index = {  
						 
		def juegos = GameObject.findAllByNameLike("%"+params.palabra+"%")
		
		[juegos: juegos]
		
	}
}
