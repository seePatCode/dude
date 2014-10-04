package dude

class Contact {
    String firstName
    String lastName

    static constraints = {
        firstName blank: false, nullable: false
        lastName blank: false, nullable: false
    }
    @Override
    public String toString(){return "${firstName} ${lastName}"}

}
