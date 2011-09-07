package pse

import java.util.Date;



/**
 * 
 * El objeto imagen, para tenerlo separado
 *
 */
class Image {

	String fileName
	GameObject gameObject

	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return fileName
	}
    static constraints = {
    }
}
