package pse

class LoginFilterFilters {
	
    def filters = {
		
        adquisition(controller:'adquisition', action:'*') {
            before = {

				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}
				
            }
        }
		category(controller:'category', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		comment(controller:'comment', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		country(controller:'country', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		gameObject(controller:'gameObject', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		image(controller:'image', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		message(controller:'message', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		plataform(controller:'plataform', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		user(controller:'user', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		video(controller:'video', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		voto(controller:'voto', action:'*') {
			before = {
				if (session.user==null){
					redirect(controller: 'login', action:'index')
					return false
				} else {
					if (!session.user.admin){
						render "Acceso no autorizado"
						return false
					}
				}

			}
		}
		
    }
    
}
