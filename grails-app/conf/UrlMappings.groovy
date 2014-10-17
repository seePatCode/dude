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
        "/savenewcontact"(controller:"application",action:"savenewcontact")
        "/updatecontact"(controller:"application",action:"updatecontact")
        "/deletecontact"(controller:"application",action:"deletecontact")
        "/findafriennd" (controllre:"application",action:"listAllUsers")
        "/logout"(controller:"auth", action: 'signOut')
        "500"(view:'/error')
	}
}
