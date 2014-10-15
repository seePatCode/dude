class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"application")
        "/viewcontact"(controller:"application",action:"viewcontact")
        "/logout"(controller:"auth", action: 'signOut')
        "500"(view:'/error')
	}
}
