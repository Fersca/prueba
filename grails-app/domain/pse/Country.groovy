package pse

import java.util.Date;

/**
 * 
 * Es un país, para hacer el árbol de países.
 *
 */
class Country {

	String name
	String flag
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return name
	}
	
    static constraints = {
    }
}
