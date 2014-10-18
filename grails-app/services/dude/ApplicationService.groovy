package dude

import grails.transaction.Transactional
import org.apache.shiro.SecurityUtils

@Transactional
class ApplicationService {

    //This should be two services but I'm just hacking along so deal with it!
    Collection<Contact> getAllContacts(){
        return getLoggedInUser().getAllContactsIncludingFriends()
    }
    Contact getContact(String contactId){
        return Contact.findById(contactId)
    }
    Contact saveNewContact(Contact contact)
    {
        contact.user = getLoggedInUser()
        contact.save()
        return contact
    }
    Contact updateContact(def params)
    {
        def contact = Contact.findById(params.id)
        contact.properties = params
        contact.save()
        return contact
    }
    ShiroUser getLoggedInUser() {
        String username = SecurityUtils.subject.principal
        return ShiroUser.findByUsername(username)
    }

    def deleteContact(Contact contact) {
        contact.delete()
    }

    def getAllUsers() {
        return ShiroUser.all
    }

    ShiroUser removeFriend(String userid) {
        def user = getLoggedInUser()
        def friend = ShiroUser.findById(userid)
        user.friends.remove(friend)
        user.save()
        return friend
    }
    ShiroUser addFriend(String userid) {
        def user = getLoggedInUser()
        def friend = ShiroUser.findById(userid)
        user.friends.add(friend)
        user.save()
        return friend
    }
    Collection<ShiroUser> getFriends(){
        return loggedInUser.friends
    }
}
