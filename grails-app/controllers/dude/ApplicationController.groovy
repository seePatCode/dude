package dude

class ApplicationController {

    def index() {
        def contacts = Contact.all
        render(view: "index", model: [contacts: contacts])
    }
}
