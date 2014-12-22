<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <jsp:include page="parts/head.jsp" />
</head>

<body>

<jsp:include page="parts/navbar.jsp" />

<div class="container">
    <div class="row">
        <h3>Messages</h3>
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
                    <c:forEach var="message" items="${messages}" varStatus="loopCounter">
                        <c:set var="index" scope="request" value="${((currentPage - 1) * 10) + loopCounter.index + 1}" />
                        <tr>
                            <td>${index}</td>
                            <td>${message.title}</td>
                            <td>${message.author}</td>
                            <td>
                                <a href="view/${message.id}">
                                    View
                                </a>
                                |
                                <a href="edit/${message.id}">
                                    Edit
                                </a>
                                |
                                <a href="remove/${message.id}">
                                    Remove
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

                <c:if test="${totalPages > 1}">
                    <div class="paginator-wrapper">
                        <div id="paginator"></div>
                    </div>
                </c:if>

            </c:when>
            <c:otherwise>
                <div class="well">No messages yet!</div>
            </c:otherwise>
        </c:choose>
    </div>

    <div class="row">
        <div class="col-md-12">
            <h3>Add new message!</h3>
            <br/>

            <form action="add" method="post" class="form-horizontal">
                <div class="form-group">
                    <label for="title" class="col-sm-2 control-label">Title:</label>

                    <div class="col-sm-10">
                        <input type="text" name="title" id="title" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="message" class="col-sm-2 control-label">Message:</label>

                    <div class="col-sm-10">
                        <input type="text" name="message" id="message" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <label for="author" class="col-sm-2 control-label">Author:</label>

                    <div class="col-sm-10">
                        <input type="text" name="author" id="author" class="form-control">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">Add</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <hr>

    <jsp:include page="parts/footer.jsp" />
</div>

<jsp:include page="parts/scripts.jsp" />

<c:if test="${totalPages > 1}">
    <script src="${pageContext.request.contextPath}/static/js/bootstrap-paginator.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $('#paginator').bootstrapPaginator({
                currentPage: ${currentPage},
                totalPages: ${totalPages},
                size: "large",
                alignment: "center",
                pageUrl: function (type, page, current) {
                    if (type == "page" && page != current) {
                        return "${pageContext.request.contextPath}/main?page=" + page;
                    }
                }
            });
        });
    </script>
</c:if>

</body>
</html>