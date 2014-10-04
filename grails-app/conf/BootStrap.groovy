import dude.Contact


class BootStrap {

    def init = { servletContext ->
        if(Contact.count==0) {
            println "in here"
            new Contact(firstName: "Pat", lastName: "Cullen").save(failOnError: true)
            new Contact(firstName: "Bob", lastName: "Smith").save(failOnError: true)
            new Contact(firstName: "James", lastName: "Franco").save(failOnError: true)
        }
        println "${Contact.find(new Contact(firstName:"Pat"))} was successfully found in the DB"
    }
    def destroy = {
    }
}
