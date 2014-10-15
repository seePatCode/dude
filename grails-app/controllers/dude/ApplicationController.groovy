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
}
