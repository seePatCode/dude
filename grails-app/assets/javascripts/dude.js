$(document).ready(function() {

    var ContactView = Backbone.Marionette.ItemView.extend({
        tagName: "li",
        template: Handlebars.compile($('#contact-template').html())
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
