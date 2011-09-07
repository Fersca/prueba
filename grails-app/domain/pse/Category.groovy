package pse

import java.util.Date;
import PSE;

/**
 * 
 * Representa la categoría de un juego: Deportes, FPS, Racing, solo aplica a los juegos
 *
 */
class Category {

	String name
	String description
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return name
	}
	static hasMany = [games: GameObject]
	
    static constraints = {
    }
	
	def permalink() {
		return '/'+PSE.appName+'/category/'+this.id+'/'+this.name.replaceAll(" ","-")
	}
}
