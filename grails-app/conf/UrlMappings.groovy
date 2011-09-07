class UrlMappings {

	static mappings = {
		
		"/game/$id/$nombre" (controller: 'gamePage', action: 'index')
		
		"/category/$id/$nombre" (controller: 'categoryPage', action: 'index')
		
		"/usuario/$id/$nombre" (controller: 'userPage', action: 'index')
		
		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}
		
		"/admins"(view:"/admins")
		
		"/"(controller: 'home')
		
		"500"(view:'/error')
	}
}
