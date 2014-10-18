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
	<body>

        <div id="content">

            <div id="contactList"></div>

        </div>

	</body>
</html>
