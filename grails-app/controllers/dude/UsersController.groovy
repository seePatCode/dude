package dude
import grails.converters.JSON
import grails.rest.RestfulController
import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils

class UsersController extends RestfulController {

    static responseFormats = ['json']

    def applicationService

    def index() {
        respond applicationService.allUsers
    }

    def show(ShiroUser user) {
        if (!user) {
            respond status: 404
        }
        respond user
    }

    @Transactional
    def update(/*ShiroUser user*/) {
        String responseText = "Updating users is not currently supported"
        response.status=501;
        respond new ErrorResponse(responseText)
    }

    @Transactional
    def save(ShiroUser user) {
        String responseText = "Saving users is not currently supported"
        response.status=501;
        respond new ErrorResponse(responseText)
    }

    def delete(ShiroUser user) {
        String responseText = "Deleting users is not currently supported"
        response.status=501;
        respond new ErrorResponse(responseText)
    }
    def listFriends(){
        respond applicationService.friends
    }
    def addFriend(String friendid){
        respond applicationService.addFriend(friendid)
    }
    def removeFriend(String friendid){
        respond applicationService.removeFriend(friendid)
    }
}
