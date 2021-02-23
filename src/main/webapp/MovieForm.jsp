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
            <a href="/new">Add New Movie</a>
            &nbsp;&nbsp;&nbsp;
            <a href="/list">List Movies</a>

        </h2>
    </center>
    <div align="center">
        <c:if test="${movie != null}">
            <form action="update" method="post">
        </c:if>
        <c:if test="${movie == null}">
            <form action="insert" method="post">
        </c:if>
        <table border="1" cellpadding="5">
            <caption>
                <h2>
                    <c:if test="${movie != null}">
                        Edit Movie
                    </c:if>
                    <c:if test="${movie == null}">
                        Add New Movie
                    </c:if>
                </h2>
            </caption>
                <c:if test="${movie != null}">
                    <input type="hidden" name="id" value="<c:out value='${movie.id}' />" />
                </c:if>
            <tr>
                <th>Title: </th>
                <td>
                    <input type="text" name="title" size="45"
                            value="<c:out value='${movie.title}' />"
                        />
                </td>
            </tr>
            <tr>
                <th>Director first name: </th>
                <td>
                    <input type="text" name="firstName" size="45"
                            value="<c:out value='${movie.director.firstName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Director last name: </th>
                <td>
                    <input type="text" name="lastName" size="45"
                           value="<c:out value='${movie.director.lastName}' />"
                    />
                </td>
            </tr>
            <tr>
                <th>Year: </th>
                <td>
                    <input type="text" name="year" size="5"
                            value="<c:out value='${movie.year}' />"
                    />
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="Save" />
                </td>
            </tr>
        </table>
        </form>
    </div>
</body>
</html>