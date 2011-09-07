package pse.web

import pse.Category;
import pse.Country;
import pse.MainCategory;
import pse.Plataform;

class HomeController {

	def StatisticsService
	
    def index = { 
		
		def topGames = StatisticsService.getTopGames()
		def topUsers = StatisticsService.getTopUsers()
		def categs = Category.list()
		def maincategs = MainCategory.list()
		def plat = Plataform.list()
		def countri = StatisticsService.getCountries()
		[maincategs: maincategs, topGames: topGames, topUsers: topUsers, categories:categs, platforms: plat, countries: countri]
	}
	
}
