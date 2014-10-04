<%--
  Created by IntelliJ IDEA.
  User: pat
  Date: 10/4/2014
  Time: 5:14 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<table class="table" id="contacts-table">
    <thead>
        <tr>
            <th>First</th>
            <th>Last</th>
        </tr>
    </thead>
    <tbody>
        <g:each in="${contacts}" var="contact">
        <tr>
            <td>${contact.firstName}</td>
            <td>${contact.lastName}</td>
        </tr>
        </g:each>
    </tbody>
</table>
</body>
</html>