class UrlMappings {

	static mappings = {

        "/"(controller: 'frontEnd', action: 'index')
        "/example/"(controller:"application")
        "/example/viewcontact"(controller:"application",action:"viewcontact")
        "/example/editcontact"(controller:"application",action:"editcontact")
        "/example/createcontact"(controller:"application",action:"createcontact")
        "/example/savenewcontact"(controller:"application",action:"savenewcontact")
        "/example/updatecontact"(controller:"application",action:"updatecontact")
        "/example/deletecontact"(controller:"application",action:"deletecontact")
        "/example/findafriennd" (controller:"application",action:"listAllUsers")
        "/example/logout"(controller:"auth", action: 'signOut')
        "500"(view:'/error')
        //========REST API ENDPOINTS======
        "/api/contacts"(resources: 'contacts')
        "/api/users"(resources: 'users')
        "/api/friends"(controller:"friends",action:"listFriends", method:"GET")
        "/api/friends/$id"(controller:"friends",action:"addFriend", method:"PUT")
        "/api/friends/$id"(controller:"friends",action:"removeFriend", method:"DELETE")
        //======END REST API ENDPOINTS====
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }
	}
}
