import dude.Contact
import dude.ShiroUser
import grails.converters.JSON
import org.apache.shiro.crypto.hash.Sha512Hash


class BootStrap {

    def init = {servletContext ->

        //Added marshaller to prevent passwordHash from going over the wire
        JSON.registerObjectMarshaller(ShiroUser) {
            def map= [:]
            map['username'] = it.username
            map['contacts'] = it.contacts
            map['id'] = it.id
            return map
        }

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
            println "Adding Second User"
            new ShiroUser(username: "john", passwordHash: new Sha512Hash("password").toHex())
                    .addToPermissions("*:*")
                    .addToContacts(new Contact(firstName: "Susan", lastName: "Jonas", phoneNumber: "867-0003"))
                    .addToContacts(new Contact(firstName: "Kara", lastName: "Watts", phoneNumber: "344-2139"))
                    .addToContacts(new Contact(firstName: "Dodo", lastName: "Mango", phoneNumber: "817-5339"))
                    .save(failOnError: true)

            new ShiroUser(username: "annie", passwordHash: new Sha512Hash("password").toHex())
                    .addToPermissions("*:*")
                    .addToContacts(new Contact(firstName: "Smit", lastName: "Wick", phoneNumber: "867-0003"))
                    .addToContacts(new Contact(firstName: "Heffe", lastName: "Vizen", phoneNumber: "344-2139"))
                    .addToContacts(new Contact(firstName: "Franz", lastName: "Zikaner", phoneNumber: "817-5339"))
                    .save(failOnError: true)

            new ShiroUser(username: "jessi", passwordHash: new Sha512Hash("password").toHex())
                    .addToPermissions("*:*")
                    .addToContacts(new Contact(firstName: "Miss", lastName: "Issipi", phoneNumber: "867-0003"))
                    .addToContacts(new Contact(firstName: "Joe", lastName: "Camel", phoneNumber: "344-2139"))
                    .addToContacts(new Contact(firstName: "Cassandra", lastName: "Mongo", phoneNumber: "817-5339"))
                    .save(failOnError: true)

            new ShiroUser(username: "larry", passwordHash: new Sha512Hash("password").toHex())
                    .addToPermissions("*:*")
                    .addToContacts(new Contact(firstName: "Lela", lastName: "Quazare", phoneNumber: "867-0003"))
                    .addToContacts(new Contact(firstName: "mmmmm", lastName: "aaaa", phoneNumber: "344-2139"))
                    .addToContacts(new Contact(firstName: "Ran out of", lastName: "Names", phoneNumber: "817-5339"))
                    .save(failOnError: true)
        }

        println "${ShiroUser.findAllByUsername("pat")} was successfully found in the DB"
    }
    def destroy = {
    }
}
