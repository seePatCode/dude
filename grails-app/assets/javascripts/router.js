// For more information see: http://emberjs.com/guides/routing/

Dude.Router.map(function() {
    this.resource('index', { path: '/' });
});

Dude.IndexRoute = Ember.Route.extend({
    model: function() {
        return this.store.find('contact');
    },
    actions: {
        newUser: function() {
            return this.render("newUserModal", {
                into: 'index',
                outlet: 'modal'
            });
        },

        closeModal: function() {
            return this.disconnectOutlet({
                outlet: 'modal',
                parentView: 'index'
            });
        }
    }
});