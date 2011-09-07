package pse

import java.util.Date;


/**
 * 
 * Es un comentario sobre cualquier GameObject, cualquier cosa puede tener un 
 * comentario, que obviamente lo hizo un usuario.
 *
 */
class Comment {

	String text
	GameObject gameObject
	User user
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return text
	}
    static constraints = {
    }
	static mapping = {
		text type: 'text'
	 }
}
