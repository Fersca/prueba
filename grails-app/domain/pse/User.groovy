package pse

import java.util.Date;


/**
 * El usuario, con sus datos personales y de contacto y su lista de adquisiciones y mensajes
 *
 */
class User {

	String nickname
	String email
	String realName
	String psnAlias
	String avatar
	String password
	Plataform favoritePlataform
	Country country
	String locationCity
	String locationCountry
	String locationFbId
	
	Boolean admin
	String facebookUserId
	
	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	def getNick(){
		if (nickname){
			return nickname
		} else {
			return realName
		}
	}
	
	String toString(){
		return getNick()
	}
	
	//Si no tiene seteado el avatar devuelve uno por default	
	def getAvatar(){
	  if (avatar)
		return avatar
	  else
		return "default_user.jpg"
	}
		
	static hasMany = [adquisitions: Adquisition, desires: Adquisition]
	
    static constraints = {
		nickname()
		nickname(nullable:true)
		psnAlias(nullable:true)
		avatar(nullable:true)
		locationFbId(nullable:true)
		locationCity(nullable:true)
		locationCountry(nullable:true)
    }
	
	def permalink() {
		return '/'+PSE.appName+'/usuario/'+this.id+'/'+this.getNick().replaceAll(" ","-")
	}
	
}
