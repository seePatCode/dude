<%--
  Created by IntelliJ IDEA.
  User: pat
  Date: 10/14/2014
  Time: 10:39 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<div class="right">
    <a href="<g:createLink action="viewcontact" params="[contactid:contact.id]" />">Back to View Contact</a>
</div>
<div style="max-width:600px;">
    <g:render template ="contactformpartial" bean="${contact}" />
</div>
</body>
</html>