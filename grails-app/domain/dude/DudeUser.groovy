package dude

class DudeUser
{
    String username
    String password

    static hasMany = [
            contacts: Contact,
            relationships: Relationship
    ]
    static constraints = {
    }
    public String toString()
    {
        return username
    }

}
