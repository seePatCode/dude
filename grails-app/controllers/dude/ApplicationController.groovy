package dude

import org.apache.shiro.SecurityUtils

class ApplicationController {
    def index() {
        String username = SecurityUtils.subject.principal
        def user = ShiroUser.findByUsername(username)
        def contacts = Contact.findAllByUser(user)
        render(view: "index", model: [contacts: contacts])
    }
    def viewcontact(String contactid){
        def contact = Contact.findById(contactid)
        render(view: "viewcontact", model: [contact: contact])
    }
    def editcontact(String contactid){
        def contact = Contact.findById(contactid)
        render(view: "editcontact", model: [contact: contact])
    }
    def createcontact(){}
    def savenewcontact(){
        def contact = new Contact(params)
        String username = SecurityUtils.subject.principal
        contact.user = ShiroUser.findByUsername(username)
        contact.save(failOnError:true)
        forward(action: "index", model: [successMessage: "${contact.firstName} was successfully created"])
    }
    def updatecontact()
    {
        def contact = Contact.findById(params.id)
        contact.properties = params
        contact.save(failOnError: true)
        forward(action: "index", model: [successMessage: "${contact.firstName} was successfully updated"])
    }
    def deletecontact(String contactid)
    {
        def contact = Contact.findById(contactid)
        if(!contact)
            redirect(action:"index")
        else {
            contact.delete(failOnError: true, flush: true)
            forward(action: "index", model: [successMessage: "${contact.firstName} was successfully deleted"])
        }
    }

}
