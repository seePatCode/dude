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
            println "Adding First User"
            new ShiroUser(username: "pat", passwordHash: new Sha512Hash("password").toHex())
                .addToPermissions("*:*")
                .addToContacts(new Contact(firstName: "Pat", lastName: "Cullen", phoneNumber: "867-5309"))
                .addToContacts(new Contact(firstName: "Bob", lastName: "Smith", phoneNumber: "344-2239"))
                .addToContacts(new Contact(firstName: "James", lastName: "Franco", phoneNumber: "817-5309"))
                .save(failOnError: true)
        }
        if (ShiroUser.count()==1){
            println "Adding Second User"
            new ShiroUser(username: "john", passwordHash: new Sha512Hash("password").toHex())
                    .addToPermissions("*:*")
                    .addToContacts(new Contact(firstName: "John", lastName: "Jones", phoneNumber: "867-0003"))
                    .addToContacts(new Contact(firstName: "Larry", lastName: "The Cable Guy", phoneNumber: "344-2139"))
                    .addToContacts(new Contact(firstName: "Cassandra", lastName: "Mongo", phoneNumber: "817-5339"))
                    .save(failOnError: true)
        }

        println "${ShiroUser.findAllByUsername("pat")} was successfully found in the DB"
    }
    def destroy = {
    }
}
