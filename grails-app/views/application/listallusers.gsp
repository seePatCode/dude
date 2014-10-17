<%--
  Created by IntelliJ IDEA.
  User: pat
  Date: 10/16/2014
  Time: 9:50 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta name="layout" content="main">
    <title></title>
</head>

<body>
<h2>Find your friends!</h2>
<div class="dude-table">
    <table class="table">
        <thead>
        <tr>
            <th>Username</th>
            <th>Note</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <g:each in="${allUsers}" var="user">
            <tr>
                <td>${user.username}</td>
                    <g:if test="${currentUser.friends.contains(user)}">
                        <td>You guys are already friends!</td>
                        <td>
                            <a href="<g:createLink action="removefriend" params="[userid:user.id]" />" class="btn btn-default btn-sm" >
                                <span class="glyphicon glyphicon-remove"></span> Remove Friend
                            </a>
                        </td>
                    </g:if>
                    <g:elseif test="${user!=currentUser}">
                        <td></td>
                        <td>
                            <a href="<g:createLink action="addfriend" params="[userid:user.id]" />" class="btn btn-default btn-sm" >
                                <span class="glyphicon glyphicon-plus"></span> Add Friend
                            </a>
                        </td>
                    </g:elseif>
                    <g:else>
                        <td>This is you!</td><td>Nothing to do here...</td>
                    </g:else>
                </td>
            </tr>
        </g:each>
        </tbody>
    </table>

</div>
</body>
</html>