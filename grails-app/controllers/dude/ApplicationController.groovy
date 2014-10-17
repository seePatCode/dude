package dude

import org.apache.shiro.SecurityUtils

class ApplicationController {
    def applicationService
    def index() {
        render(view: "index", model: [contacts: applicationService.getAllContacts()])
    }
    def viewcontact(String contactid){
        render(view: "viewcontact", model: [contact: applicationService.getContact(contactid)])
    }
    def editcontact(String contactid){
        render(view: "editcontact", model: [contact: applicationService.getContact(contactid)])
    }
    def createcontact(){}
    def savenewcontact(){
        forward(action: "index", model: [successMessage: "${applicationService.saveNewContact(new Contact(params)).firstName} was successfully created"])
    }
    def updatecontact(){
        forward(action: "index", model: [successMessage: "${applicationService.updateContact(params).firstName} was successfully updated"])
    }
    def deletecontact(String contactid)
    {
        def contact = applicationService.getContact(contactid)
        if(!contact)
            redirect(action:"index")
        else {
            applicationService.deleteContact(contact)
            forward(action: "index", model: [successMessage: "${contact.firstName} was successfully deleted"])
        }
    }
    def listAllUsers()
    {
        render(view: 'listallusers', model: [currentUser: applicationService.getLoggedInUser(),
                                             allUsers: applicationService.getAllUsers()])
    }

    def removefriend(String userid)
    {
        forward(action: "index", model: [successMessage: "${applicationService.removeFriend(userid).username} defriended :("])
    }
    def addfriend(String userid)
    {
        forward(action: "index", model: [successMessage: "${applicationService.addFriend(userid).username} friended!"])
    }

}
