package pse

import java.util.Date;


/**
 * 
 * Representa cada objeto adquirido por el usuario, donde cada uno el del tipo
 * GameObject, lo cual puede ser un juego o accesorio, cada adquisicion puede
 * prestarse o venderse
 *
 */
class Adquisition {

	GameObject gameObject
	User user
	BigDecimal price
	boolean availableSelling
	boolean availableExchange
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated
	
	String toString(){
		return gameObject
	}
	
    static constraints = {
    }
}
