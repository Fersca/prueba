package pse

import java.util.Date;



/**
 * El objeto que representa los videos de los GameObjects
 */
class Video {

	String link
	GameObject gameObject
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return link
	}
	
    static constraints = {
    }
}
