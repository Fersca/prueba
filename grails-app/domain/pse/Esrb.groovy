package pse

import java.util.Date;

class Esrb {

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
