$(document).ready(function() {

    var ContactView = Backbone.Marionette.ItemView.extend({
        tagName: "li",
        template: _.template("<a href='<%-name%>'><%-name%></a>")
    });

    var ContactListView = Backbone.Marionette.CollectionView.extend({
        tagName: 'ul',
        childView: ContactView
    });

    var list = new Backbone.Collection([
        {name: 'Link'},
        {name: 'Zelda'}
    ]);

    (new ContactListView({
        collection: list,
        el: '#contactList'
    })).render();

});
