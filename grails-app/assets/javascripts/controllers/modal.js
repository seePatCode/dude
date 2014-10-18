Dude.NewUserModalController = Ember.ArrayController.extend({
    actions: {
        save: function() {
            var newDude = this.store.createRecord('Contact', {
                firstName: this.get("firstName"),
                lastName: this.get("lastName"),
                phoneNumber: this.get("phoneNumber")
            });

            this.set('firstName','');
            this.set('lastName','');
            this.set('phoneNumber','');

            newDude.save();

            this.send('close');
        },
        close: function() {
            return this.send('closeModal');
        }
    }
});

Dude.NewUserModalDialogComponent = Ember.Component.extend({
    actions: {
        close: function() {
            return this.sendAction();
        }
    }
});
