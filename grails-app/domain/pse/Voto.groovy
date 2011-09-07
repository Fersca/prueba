package pse

import java.util.Date;

class Voto {

	GameObject game
	User user
	Integer points
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return points
	}
    static constraints = {
    }
}
