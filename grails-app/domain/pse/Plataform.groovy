package pse

import java.util.Date;

/**
 * Representa el tipo de plataforma, no la consola: PS3, PS2, XBOX
 *
 */
class Plataform {

	String name
	String description
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return name
	}
    static constraints = {
    }
}
