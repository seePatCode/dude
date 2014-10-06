package dude

class Contact {
    String firstName
    String lastName
    String phoneNumber

    static belongsTo = [user: DudeUser]
    static constraints = {
        firstName blank: false, nullable: false
        lastName blank: false, nullable: false
    }
    @Override
    public String toString(){return "${firstName} ${lastName}"}

}
