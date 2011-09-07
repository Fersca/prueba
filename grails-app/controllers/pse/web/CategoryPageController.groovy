package pse.web

import pse.Category;
import pse.GameObject;

class CategoryPageController {

	def index = {
		
		Category catego = Category.get(params.id)
		 
		def juegos = GameObject.findAllByCategory(catego)
		
		if (juegos){
			[juegos: juegos, catego: catego]
		} else {
			render "No se encontraron Juegos"
		}
		
	}
}
