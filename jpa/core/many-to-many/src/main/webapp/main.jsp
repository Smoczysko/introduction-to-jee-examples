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
                        <tr>
                            <td>${message.id}</td>
                            <td>${message.title}</td>
                            <td>${message.author}</td>
                            <td>
                                <a href="view/${message.id}">
                                    View
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>

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
                    <label for="tags" class="col-sm-2 control-label">Tags (comma-separated):</label>

                    <div class="col-sm-10">
                    <c:choose>
                        <c:when test="${tags.size() > 0}">
                            <select name="tags" id="tags" class="form-control" multiple>
                                <c:forEach var="tag" items="${tags}">
                                    <option value="${tag.id}">${tag}</option>
                                </c:forEach>
                            </select>
                        </c:when>
                        <c:otherwise>
                            No tags available!
                        </c:otherwise>
                    </c:choose>
                    <a href="tag/add.jsp">Add new tag</a>
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
</body>
</html>