import dude.Contact
import dude.ShiroUser
import org.apache.shiro.crypto.hash.Sha512Hash


class BootStrap {

    def init = { servletContext ->
        //Drop every user on start, we don't gotta deal with a stable db for this hackathon
        ShiroUser.all.each {dudeUser ->
            dudeUser.delete()
        }
        if(ShiroUser.count==0) {
            println "in here"
            new ShiroUser(username: "pat", passwordHash: new Sha512Hash("password").toHex())
                .addToPermissions("*:*")
                .addToContacts(new Contact(firstName: "Pat", lastName: "Cullen", phoneNumber: "867-5309"))
                .addToContacts(new Contact(firstName: "Bob", lastName: "Smith", phoneNumber: "344-2239"))
                .addToContacts(new Contact(firstName: "James", lastName: "Franco", phoneNumber: "817-5309"))
                .save(failOnError: true)
        }
        println "${ShiroUser.findAllByUsername("pat")} was successfully found in the DB"
    }
    def destroy = {
    }
}
