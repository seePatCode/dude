$(document).ready(function() {

    var ContactView = Backbone.Marionette.ItemView.extend({
        tagName: "tr",
        template: Handlebars.compile($('#contact-template').html()),

        initialize: function() {
            this.listenTo(this.model, 'change', function() {
                this.model.save();
            })
        },

        events: {
            'keyup .first-name input': function() { this.saveField('firstName', event); },
            'keyup .last-name input': function() { this.saveField('lastName', event); }
        },

        saveField: _.debounce(function(field, event) {
            this.model.set(field, event.target.value);
        }, 500)
    });

    var ContactListView = Backbone.Marionette.CollectionView.extend({
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
