<!DOCTYPE html>
<html>
	<head>

        %{-- jQuery --}%
        <g:javascript library="jquery" plugin="jquery" />

        %{-- Underscore --}%
        <asset:javascript src="underscore.min.js" />

        %{-- Backbone --}%
        <asset:javascript src="backbone/backbone.min.js" />

        %{-- Marionette --}%
        <asset:javascript src="marionette-bundled.ming.js" />

        %{-- Angular --}%
        <asset:javascript src="angular/angular.min.js" />

        %{-- Ember --}%
        <asset:javascript src="ember/ember-1.7.0.js" />
        <asset:javascript src="ember/app.js" />
        <asset:stylesheet src="ember/normalize.css" />
        <asset:stylesheet src="ember/style.css" />

        %{-- React --}%
		<asset:javascript src="react/react.min.js" />
		<asset:javascript src="react/JSXTransformer.js" />

        %{-- Your code --}%
        <asset:javascript src="dude.js" />
        <asset:stylesheet src="dude.less" />

	</head>
	<body>

        Fill this with your dreams

	</body>
</html>
