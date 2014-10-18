<!DOCTYPE html>
<html>
	<head>

        <link rel="stylesheet" href="http://yui.yahooapis.com/pure/0.5.0/pure-min.css">

        %{-- jQuery --}%
        <g:javascript library="jquery" plugin="jquery" />

        %{-- Underscore --}%
        <asset:javascript src="underscore/underscore.min.js" />

        %{-- Backbone --}%
        <asset:javascript src="backbone/backbone.min.js" />

        %{-- Marionette --}%
        <asset:javascript src="marionette/marionette-bundled.min.js" />

        %{-- Handlebars --}%
        <asset:javascript src="handlebars/handlebars-v2.0.0.js" />

        %{-- Angular --}%
        %{--<asset:javascript src="angular/angular.min.js" />--}%

        %{-- Ember --}%
        %{--<asset:javascript src="ember/ember-1.7.0.js" />--}%
        %{--<asset:javascript src="ember/app.js" />--}%
        %{--<asset:stylesheet src="ember/normalize.css" />--}%
        %{--<asset:stylesheet src="ember/style.css" />--}%

        %{-- React --}%
		%{--<asset:javascript src="react/react.min.js" />--}%
		%{--<asset:javascript src="react/JSXTransformer.js" />--}%

        %{-- Your code --}%
        <asset:javascript src="dude.js" />
        <asset:stylesheet src="dude.less" />

	</head>
	<body class="yui3-normalized">

        <div class="header">
            <div class="home-menu pure-menu pure-menu-open pure-menu-horizontal">
                <a class="pure-menu-heading" href="">Dude!</a>

                <ul>
                    %{--<li class="pure-menu-selected"><a href="#">Home</a></li>--}%
                    %{--<li><a href="#">Tour</a></li>--}%
                    %{--<li><a href="#">Sign Up</a></li>--}%
                </ul>
            </div>
        </div>

        <div id="content" class="">

            <table class="pure-table pure-table-horizontal pure-table-striped">
                <thead>
                    <tr>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Phone Number</th>
                    </tr>
                </thead>
                <tbody id="contactList">
                </tbody>
            </table>

        </div>

        <script id="contact-template" type="text/x-handlebars-template">
            <td>{{firstName}}</td>
            <td>{{lastName}}</td>
            <td>{{phoneNumber}}</td>
        </script>

	</body>
</html>
