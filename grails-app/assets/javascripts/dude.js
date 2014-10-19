/** @jsx React.DOM */

var DudeApp = React.createClass({
    getInitialState: function () {
        return {tab: 'contacts'};
    },
    selectContactsTab: function () {
        this.setState({tab: 'contacts'});
    },
    selectFriendsTab: function () {
        this.setState({tab: 'friends'});
    },
    render: function () {
        var tabContent;
        if (this.state.tab === 'contacts') {
            tabContent = <ContactsTabContent url="/dude/api/contacts" />;
        }
        else if (this.state.tab === 'friends') {
            tabContent = <FriendsTabContent url="/dude/api/users" />;
        }
        return (
            <div className="app">
                <div className="header">
                    <div className="content">
                        <h1>
                            Dude!
                        </h1>
                        <div className="tabs">
                            <Tab name="Contacts" selected={this.state.tab === 'contacts'} onClick={this.selectContactsTab} />
                            <Tab name="Find Friends" selected={this.state.tab === 'friends'} onClick={this.selectFriendsTab} />
                        </div>
                    </div>
                </div>
                <div className="content">

                    <div className="tabContent">
                        {tabContent}
                    </div>
                </div>
            </div>
        )
    }
});

var Tab = React.createClass({
    handleClick: function () {
        this.props.onClick(this);
    },
    render: function () {
        return (
            <a className={this.props.selected ? 'tab selected' : 'tab'} onClick={this.handleClick}>
                {this.props.name}
            </a>
        )
    }
});

var ContactsTabContent = React.createClass({
    getInitialState: function () {
        return {contacts: [], isCreateContactFormVisible: false};
    },
    loadContactsFromServer: function () {
        $.ajax({
            url: this.props.url,
            dataType: 'json',
            success: function (contacts) {
                this.setState({contacts: contacts});
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        })
    },
    componentDidMount: function () {
        this.loadContactsFromServer();
        this.updateContact = _.debounce(function (contact) {
            $.ajax({
                url: this.props.url + "/" + contact.id,
                data: JSON.stringify(contact),
                method: 'PUT',
                dataType: 'json',
                contentType: "application/json; charset=UTF-8",
                processData: false,
                traditional: false,
                success: function () {
                    this.loadContactsFromServer();
                }.bind(this),
                error: function (xhr, status, err) {
                    console.error(this.props.url, status, err.toString());
                }.bind(this)
            })
        }.bind(this), 1000);
    },
    handleContactSubmit: function (contact) {
        var contacts = this.state.contacts;
        var newcontacts = contacts.concat([contact]);
        this.setState({contacts: newcontacts, isCreateContactFormVisible: false});
        $.ajax({
            url: this.props.url,
            data: JSON.stringify(contact),
            method: 'POST',
            dataType: 'json',
            contentType: "application/json; charset=UTF-8",
            processData: false,
            success: function () {
                this.loadContactsFromServer();
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },
    handleContactDelete: function (contact) {
        var contacts = this.state.contacts;
        var newcontacts = _.without(contacts, contact);
        this.setState({contacts: newcontacts});
        $.ajax({
            url: this.props.url + "/" + contact.id,
            data: JSON.stringify(contact),
            method: 'DELETE',
            dataType: 'json',
            contentType: "application/json; charset=UTF-8",
            processData: false,
            success: function () {
                this.loadContactsFromServer();
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },
    handleContactUpdate: function (contactUpdate) {
        var existingContact = _.find(this.state.contacts, function (it) { return it.id === contactUpdate.id });
        existingContact.firstName = contactUpdate.firstName;
        existingContact.lastName = contactUpdate.lastName;
        existingContact.phoneNumber = contactUpdate.phoneNumber;
        this.setState({contacts: this.state.contacts});
        this.updateContact(existingContact);
    },
    showCreateContactForm: function () {
        this.setState({isCreateContactFormVisible: true});
    },
    render: function () {
        var createContactSection;
        if (this.state.isCreateContactFormVisible) {
            createContactSection = <ContactForm onContactSubmit={this.handleContactSubmit} />;
        }
        else {
            createContactSection = <button onClick={this.showCreateContactForm}><i className="fa fa-plus"></i> Contact</button>
        }
        return (
            <div className="contacts">
                {createContactSection}
                <ContactList
                    contacts={this.state.contacts}
                    onContactDelete={this.handleContactDelete}
                    onContactUpdate={this.handleContactUpdate}
                />
            </div>
        );
    }
});

var ContactList = React.createClass({
    render: function () {
        var contactNodes = this.props.contacts.map(function (contact) {
            return (
                <ContactRow
                    contact={contact}
                    onContactDelete={this.props.onContactDelete}
                    onContactUpdate={this.props.onContactUpdate}
                />
            );
        }.bind(this));
        return (
            <div className="contactList">
                {contactNodes}
            </div>
        )
    }
});

var ContactForm = React.createClass({
    componentDidMount: function () {
        this.refs.firstName.getDOMNode().focus();
    },
    handleSubmit: function (e) {
        e.preventDefault();
        var firstName = this.refs.firstName.getDOMNode().value.trim();
        var lastName = this.refs.lastName.getDOMNode().value.trim();
        var phoneNumber = this.refs.phoneNumber.getDOMNode().value.trim();
        if (!firstName || !lastName || !phoneNumber) {
            return;
        }
        this.props.onContactSubmit({
            firstName: firstName,
            lastName: lastName,
            phoneNumber: phoneNumber
        });
        this.refs.firstName.getDOMNode().value = '';
        this.refs.lastName.getDOMNode().value = '';
        this.refs.phoneNumber.getDOMNode().value = '';
    },
    render: function () {
        return (
            <form className="contactForm" onSubmit={this.handleSubmit}>
                <input type="text" placeholder="First name" ref="firstName" className="firstName" />
                <input type="text" placeholder="Last name" ref="lastName" className="lastName" />
                <input type="text" placeholder="Phone number" ref="phoneNumber" className="firstName" />
                <button type="submit"><i className="fa fa-plus"></i> Contact</button>
            </form>
        )
    }
});

var ContactRow = React.createClass({
    handleDelete: function () {
        this.props.onContactDelete(this.props.contact);
    },
    handleUpdate: function () {
        var firstName = this.refs.firstName.getDOMNode().value;
        var lastName = this.refs.lastName.getDOMNode().value;
        var phoneNumber = this.refs.phoneNumber.getDOMNode().value;
        this.props.onContactUpdate({
            id: this.props.contact.id,
            firstName: firstName,
            lastName: lastName,
            phoneNumber: phoneNumber
        });
    },
    render: function () {
        var contact = this.props.contact;
        return (
            <div className="row">
                <div className="name">
                    <input
                        className="firstName"
                        value={contact.firstName}
                        ref="firstName"
                        onChange={this.handleUpdate}
                    />
                    <input
                        className="lastName"
                        value={contact.lastName}
                        ref="lastName"
                        onChange={this.handleUpdate}
                    />
                </div>
                <div className="phone">
                    <i className="fa fa-phone"></i>
                    <input
                        className="phoneNumber"
                        value={contact.phoneNumber}
                        ref="phoneNumber"
                        onChange={this.handleUpdate}
                    />
                </div>
                <div className="controls">
                    <a onClick={this.handleDelete}><i className="fa fa-trash-o"></i></a>
                </div>
            </div>
        );
    }
});

var FriendsTabContent = React.createClass({
    getInitialState: function () {
        return {people: []};
    },
    loadFriendsFromServer: function () {
        $.ajax({
            url: this.props.url,
            dataType: 'json',
            success: function (people) {
                this.setState({people: people});
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        })
    },
    componentDidMount: function () {
        this.loadFriendsFromServer();
    },
    render: function () {
        return (
            <div className="friendsTabContent">
                <h2>
                    Out of Order
                </h2>
                <FriendList people={this.state.people} />
            </div>
        )
    }
});

var FriendList = React.createClass({
    render: function () {
        var friendNodes = this.props.people.map(function (person) {
            return (
                <FriendRow
                    person={person}
                    onAddFriend={this.props.onAddFriend}
                />
                );
        }.bind(this));
        return (
            <div className="contactList">
                {friendNodes}
            </div>
            )
    }
});

var FriendRow = React.createClass({
    handleAddFriend: function () {
        this.props.onAddFriend(this);
    },
    render: function () {
        var person = this.props.person;
        return (
            <div className="row">
                <div className="name">
                    {person.username}
                </div>
            </div>
        )
    }
});

React.renderComponent(
    <DudeApp />,
    document.getElementById('content')
);