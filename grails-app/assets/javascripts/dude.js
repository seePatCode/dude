$(document).ready(function() {

    var ContactView = Backbone.Marionette.ItemView.extend({
        tagName: "tr",
        template: Handlebars.compile($('#contact-template').html()),

        events: {
            'click a': 'openModel'
        },

        openModel: function(event) {
            event.preventDefault();
            alert(this.model.get('firstName'));

        }
    });

    var ContactListView = Backbone.Marionette.CollectionView.extend({
        //tagName: "tr",
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
