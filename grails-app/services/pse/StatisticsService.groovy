package pse

import dal.SQLCursor;
import PSE;

class StatisticsService {

    static transactional = true
	
	/**
	 * Devuelve la lista de mejores juegos
	 * @return
	 */
    def getTopGames() {
			
		def query = 
		'''
		select * from (
		select g.icon icon, g.id id, g.name name , avg(points) points, count(1) cant from game_object g, voto v
		where v.game_id=g.id
		group by g.id
		order by avg(points) desc) a 
		limit 0,5
		'''
	
		SQLCursor sql= new SQLCursor(query)
		
		def top = []
		
		while(sql.next()){
			GameDto dto = new GameDto()
			dto.id = sql.getInt("id")
			dto.name = sql.getString("name")
			dto.points = sql.getDouble("points")
			dto.cant = sql.getInt("cant")
			dto.icon = sql.getString("icon")
			top << dto
		}
	
		return top		
    }
	
	def getCountries(){
		
		def query = 
		'''
		select name, flag, IFNULL(CANT.cant,0) cant from country as C left join 
		(select country_id, count(1) cant from user
		group by country_id) as CANT
		ON C.id = CANT.country_id
		order by CANT.cant desc, C.name asc
		'''
		
		SQLCursor sql= new SQLCursor(query)
		
		def top = []
		
		while(sql.next()){
			CountryDto dto = new CountryDto()
			dto.name=sql.getString("name")
			dto.flag = sql.getString("flag")
			dto.cant = sql.getInt("cant")
			top << dto
		}
	
		return top
				
	}
	
	def getTopUsers(){
		
		def query =
		'''
		select * from (
		select flag, id, IFNULL(nickname,realname) nickname, comentarios+adquisiciones+votos+mensajes puntos from (
		select u.id id, u.nickname nickname, u.real_name realname, 
		(select flag from country c where c.id=u.country_id) flag,
		(select count(1) from comment c where c.user_id = u.id  and last_updated BETWEEN NOW() - INTERVAL 30 DAY AND NOW()) comentarios,
		(select count(1) from adquisition a where a.user_id = u.id and last_updated BETWEEN NOW() - INTERVAL 30 DAY AND NOW()) adquisiciones,
		(select count(1) from voto v where v.user_id = u.id and last_updated BETWEEN NOW() - INTERVAL 30 DAY AND NOW()) votos,
		(select count(1) from message m where m.to_user_id = u.id and last_updated BETWEEN NOW() - INTERVAL 30 DAY AND NOW()) mensajes
		from user u
		) a
		order by puntos desc) a
		limit 0,5
		'''
	
		SQLCursor sql= new SQLCursor(query)
		
		def top = []
		
		while(sql.next()){
			UserDto dto = new UserDto()
			dto.id=sql.getInt("id")
			dto.nick = sql.getString("nickname")
			dto.points = sql.getInt("puntos")
			dto.flag = sql.getString("flag")
			top << dto
		}
	
		return top
		
	}
}

class CountryDto {
	def name
	def flag
	def cant	
}


class GameDto {
	def id
	def name
	def points
	def cant
	def icon
	
	//Cuando se cambie esto, cambiar tambien el permalink de GameObject	
	def permalink() {
		return '/'+PSE.appName+'/game/'+this.id+'/'+this.name.replaceAll(" ","-")
	}	
}

class UserDto {
	def id 
	def nick
	def points
	def flag	
	def realname
		
	//Cuando se cambie esto, cambiar tambien el permalink de GameObject
	def permalink(){
				
		return '/'+PSE.appName+'/usuario/'+this.id+'/'+this.nick.replaceAll(" ","-")
		
	}
	
}

