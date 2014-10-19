package dude

import grails.rest.RestfulController
import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils

class ContactsController {

    static responseFormats = ['json']

    def applicationService

    def index() {
        respond applicationService.allContacts.sort { it.id }
    }

    def show(Contact contact) {
        if (!contact) {
            respond status: 404
        }
        respond contact
    }

    def update(Contact contact) {
        if (!applicationService.getContact(contact.id.toString())) {
            render status: 404
        }
        else {
            contact.save(failOnError: true)
            respond contact
        }
    }

    def save(Contact contact) {
        String username = SecurityUtils.subject.principal
        contact.user = ShiroUser.findByUsername(username)
        contact.save(failOnError:true)
        respond contact
    }

    def delete(Contact contact) {
        if (!contact) {
            render status: 404
        }
        else {
            contact.delete(failOnError: true, flush: true)
            respond([success: true])
        }
    }

}
