$(document).ready(function() {

    var ContactView = Backbone.Marionette.ItemView.extend({
        tagName: "li",
        template: _.template("<a href='example/viewcontact?contactid=<%-id%>'><%-firstName%> <%-lastName%></a>")
    });

    var ContactListView = Backbone.Marionette.CollectionView.extend({
        tagName: 'ul',
        childView: ContactView
    });

    var ContactCollection = Backbone.Collection.extend({
        url: '/dude/api/contacts'
    });

    var contacts = new ContactCollection();

    (new ContactListView({
        collection: contacts,
        el: '#contactList'
    })).render();

    contacts.fetch();


});
