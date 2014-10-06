import dude.Contact
import dude.DudeUser


class BootStrap {

    def init = { servletContext ->
        if(DudeUser.count==0) {
            println "in here"
            new DudeUser(username: "pat", password: "abc123")
                .addToContacts(new Contact(firstName: "Pat", lastName: "Cullen", phoneNumber: "867-5309"))
                .addToContacts(new Contact(firstName: "Bob", lastName: "Smith", phoneNumber: "344-2239"))
                .addToContacts(new Contact(firstName: "James", lastName: "Franco", phoneNumber: "817-5309"))
                .save(failOnError: true)
        }
        println "${DudeUser.findAllByUsername("pat")} was successfully found in the DB"
    }
    def destroy = {
    }
}
