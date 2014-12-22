<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="parts/head.jsp"/>
</head>

<body>

<jsp:include page="parts/navbar.jsp"/>

<div class="container">
    <div class="row">
        <h3>${headerText}</h3>
        <br/>

        <c:choose>
            <c:when test="${messages.size() > 0}">
                <table class="table table-striped">
                    <tr>
                        <th>#</th>
                        <th>Title</th>
                        <th>Author</th>
                        <th>Actions</th>
                    </tr>
                    <c:forEach var="message" items="${messages}">
                        <tr>
                            <td>${message.id}</td>
                            <td>${message.title}</td>
                            <td>${message.author}</td>
                            <td>
                                <a href="view/${message.id}">
                                    View
                                </a>
                                |
                                <a href="remove/${message.id}">
                                    Remove
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <div class="well">No messages found!</div>
            </c:otherwise>
        </c:choose>
    </div>

    <hr>

    <jsp:include page="parts/footer.jsp"/>
</div>

<jsp:include page="parts/scripts.jsp"/>
</body>
</html>