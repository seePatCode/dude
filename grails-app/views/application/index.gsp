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
<div id="contacts-table">
    <g:if test="${successMessage}">
        <div class="alert alert-success">
            <a href="#" class="close" data-dismiss="alert">&times;</a>
            ${successMessage}
        </div>
    </g:if>
    <div style="margin-bottom:10px">
        <a href="<g:createLink action="createcontact" />" class="btn btn-default btn-lg">
            <span class="glyphicon glyphicon-plus"></span> Add Contact
        </a>
    </div>
    <table class="table">
        <thead>
            <tr>
                <th>First</th>
                <th>Last</th>
                <th>Yo Digits</th>
            </tr>
        </thead>
        <tbody>
            <g:each in="${contacts}" var="contact">
            <tr data-url="<g:createLink action="viewcontact" params="[contactid:contact.id]" />">
                <td>${contact.firstName}</td>
                <td>${contact.lastName}</td>
                <td>${contact.phoneNumber}</td>
            </tr>
            </g:each>
        </tbody>
    </table>
</div>
</body>
</html>