package dude

import grails.rest.RestfulController
import grails.transaction.Transactional

class FriendsController extends RestfulController {

    static responseFormats = ['json']

    def applicationService

    def listFriends(){
        respond applicationService.friends
    }
    def addFriend(String id){
        respond applicationService.addFriend(id)
    }
    def removeFriend(String id){
        respond applicationService.removeFriend(id)
    }
}
