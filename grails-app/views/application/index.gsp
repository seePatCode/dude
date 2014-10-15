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
    <g:javascript library="jquery" plugin="jquery"/>
    <script>
           $(document).ready(function(){
               $("#contacts-table").on("click", "tbody tr", function(){
                    window.location = $(this).attr("data-url");
               });
           });
    </script>
</head>

<body>
<table class="table" id="contacts-table">
    <thead>
        <tr>
            <th>First</th>
            <th>Last</th>
            <th>Yo Digits</th>
        </tr>
    </thead>
    <tbody>
        <g:each in="${contacts}" var="contact">
        <tr data-url="/dude/viewcontact?contactid=${contact.id}">
            <td>${contact.firstName}</td>
            <td>${contact.lastName}</td>
            <td>${contact.phoneNumber}</td>
        </tr>
        </g:each>
    </tbody>
</table>
</body>
</html>