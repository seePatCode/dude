class UrlMappings {

	static mappings = {

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
