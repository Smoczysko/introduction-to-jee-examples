<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="../parts/head.jsp" />
</head>

<body>

<jsp:include page="../parts/navbar.jsp" />

<div class="container">
    <div class="row">
        <h3>Message</h3>
        <br/>

        <p>Title:</p>
        <div class="well well-sm">${message.title}</div>

        <p>Author:</p>
        <div class="well well-sm">${message.author}</div>

        <p>Created:</p>
        <div class="well well-sm">${message.createdAt}</div>

        <p>Message:</p>
        <div class="well well-lg">${message.message}</div>

        <p>Tags:</p>
        <div class="well well-lg">
            <c:choose>
                <c:when test="${message.tags.size() > 0}">
                    <c:forEach var="tag" items="${message.tags}" varStatus="loop">
                        ${tag}
                        <c:if test="${!loop.last}">, </c:if>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    No tags available for this message!
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <hr>

    <jsp:include page="../parts/footer.jsp" />
</div>

<jsp:include page="../parts/scripts.jsp" />
</body>
</html>