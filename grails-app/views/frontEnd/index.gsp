<!DOCTYPE html>
<html>
	<head>

        <title>Dude</title>

        %{-- jQuery --}%
        <g:javascript library="jquery" plugin="jquery" />

        %{-- Underscore --}%
        <asset:javascript src="underscore/underscore.min.js" />

        %{-- Backbone --}%
        %{--<asset:javascript src="backbone/backbone.min.js" />--}%

        %{-- Marionette --}%
        %{--<asset:javascript src="marionette-bundled.ming.js" />--}%

        %{-- Angular --}%
        %{--<asset:javascript src="angular/angular.min.js" />--}%

        %{-- Ember --}%
        %{--<asset:javascript src="ember/ember-1.7.0.js" />--}%
        %{--<asset:javascript src="ember/app.js" />--}%
        <asset:stylesheet src="ember/normalize.css" />
        %{--<asset:stylesheet src="ember/style.css" />--}%

        %{-- React --}%
		<asset:javascript src="react/react.min.js" />
		<asset:javascript src="react/JSXTransformer.js" />

        %{-- Your code --}%
        <script src="assets/dude.js" type="text/jsx"></script>
        <asset:stylesheet src="dude.less" />

        <link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
        <link href='http://fonts.googleapis.com/css?family=Roboto+Condensed:400,700,300' rel='stylesheet' type='text/css'>
        <link href='http://fonts.googleapis.com/css?family=Gloria+Hallelujah' rel='stylesheet' type='text/css'>

	</head>
	<body>

        <div id="content"></div>

	</body>
</html>
