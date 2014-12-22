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

        <p>Comments:</p>
        <div class="well">
            <c:choose>
                <c:when test="${message.comments.size() > 0}">
                    <c:forEach var="comment" items="${message.comments}" varStatus="loop">
                        <p>${comment}</p>

                        <c:if test="${!loop.last}">
                            <hr />
                        </c:if>

                    </c:forEach>
                </c:when>
                <c:otherwise>
                    No comments yet!
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <hr>

    <div class="row">
        <div class="col-md-12">
            <h3>Add comment:</h3>
            <br/>

            <form action="${pageContext.request.contextPath}/comments/add/${message.id}" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="message" class="col-sm-2 control-label">Message:</label>

                    <div class="col-sm-10">
                        <input type="text" name="message" id="message" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Save</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <jsp:include page="../parts/footer.jsp" />
</div>

<jsp:include page="../parts/scripts.jsp" />
</body>
</html>