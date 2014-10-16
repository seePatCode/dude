class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:"application")
        "/viewcontact"(controller:"application",action:"viewcontact")
        "/editcontact"(controller:"application",action:"editcontact")
        "/createcontact"(controller:"application",action:"createcontact")
        "/updatecontact"(controller:"application",action:"updatecontact")
        "/logout"(controller:"auth", action: 'signOut')
        "500"(view:'/error')
	}
}
