package pse

import java.util.Date;

class MainCategory {

	String name
	String description
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return name
	}
	static hasMany = [categories: Category]
	
	static constraints = {
	}
	
}
