package dude

class Relationship {
    static belongsTo = ShiroUser
    static hasMany = [
            users: ShiroUser
    ]
    static constraints = {
    }
}
