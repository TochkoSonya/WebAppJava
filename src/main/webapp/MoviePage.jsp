<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Movies Store Application</title>
</head>
<body>
    <center>
        <h1>Movies Management</h1>
        <h2>
            <a href="/new">Add Movie</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List Movies</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Movies</h2></caption>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Director</th>
                <th>Year</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="movie" items="${listMovie}">
                <tr>
                    <td><c:out value="${movie.id}" /></td>
                    <td><c:out value="${movie.title}" /></td>
                    <td><c:out value="${movie.year}" /></td>
                    <td><c:out value="${movie.director.toString()}" /></td>
                    <td>
                        <a href="/edit?id=<c:out value='${movie.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/delete?id=<c:out value='${movie.id}' />">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>
