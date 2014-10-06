package dude

class Relationship {
    static belongsTo = DudeUser
    static hasMany = [
            users: DudeUser
    ]
    static constraints = {
    }
}
