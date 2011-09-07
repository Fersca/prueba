package pse

import java.util.Date;



/**
 * Un mensaje puede enviarse entre usuarios, por ahora es solamente una simple 
 * herramienta de mensajería
 *
 */
class Message {

	String subject
	User fromUser
	User toUser
	String text
	Date createdDate

	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return subject+"-"+text
	}
	
	//Si fue leído o no por el receiver
	Boolean readByReceiver

    static constraints = {
    }
}
