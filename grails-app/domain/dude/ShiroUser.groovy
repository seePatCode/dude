package dude

import org.apache.shiro.crypto.hash.Sha512Hash

class ShiroUser {
    String username
    String passwordHash
    
    static hasMany = [ roles: ShiroRole,
                       permissions: String,
                       contacts: Contact,
                       relationships: Relationship]

    static constraints = {
        username(nullable: false, blank: false, unique: true)
    }
    public String toString()
    {
        return username
    }
}
