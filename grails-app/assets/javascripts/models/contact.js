Dude.Contact = DS.Model.extend({
    firstName: DS.attr('string'),
    lastName: DS.attr('string'),
    phoneNumber: DS.attr('string')
});

Dude.Contact.FIXTURES = [
    {
        id: 1,
        firstName: 'Justin',
        lastName: "DiPierro",
        phoneNumber: "123-1234"
    },
    {
        id: 2,
        firstName: 'Pat',
        lastName: "Cullen",
        phoneNumber: "123-1234"
    },
    {
        id: 3,
        firstName: 'Shawn',
        lastName: "Turner",
        phoneNumber: "123-1234"
    }
];