package pse

import java.util.Date;



/**
 * 
 * Es la entidad principal del catalogo de productos, por más que sea un juego u
 * objeto físico, el mismo podrá tener comentatios, imágenes y videos y una review
 *
 */
class GameObject {

	String name
	String description
	String review
	Category category
	String icon
	String publisher
	String players
	Double pageRating
	Esrb esrb
	Date releaseDate
	boolean assesorie

	//Estas se completan automáticamente por GORM
	Date dateCreated
	Date lastUpdated

	String toString(){
		return name
	}
	static hasMany = [points: Voto,plataforms: Plataform, comments: Comment, images: Image, videos: Video]

    static constraints = {
		name()
		publisher()
    }
	
	static mapping = {
		review type: 'text'
	 }
	 
	def permalink() {
		return '/'+PSE.appName+'/game/'+this.id+'/'+this.name.replaceAll(" ","-")
	}
	
}
