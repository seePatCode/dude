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
    <a href="<g:createLink action="editcontact" params="[contactid:contact.id]" />">Edit Contact</a>
</div>
<h1>${contact.firstName} ${contact.lastName}</h1>
<h2>${contact.phoneNumber}</h2>
</body>
</html>