package dude


class ShiroUser {
    String username
    String passwordHash
    
    static hasMany = [ roles: ShiroRole,
                       permissions: String,
                       contacts: Contact,
                       friends: ShiroUser]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
    public Collection<Contact> getAllContactsIncludingFriends()
    {
        Set<Contact> allContacts = new HashSet<Contact>();
        for(ShiroUser u: friends)
            allContacts.addAll(u.contacts)
        allContacts.addAll(contacts)
        return allContacts
    }
    public String toString()
    {
        return username
    }
}
