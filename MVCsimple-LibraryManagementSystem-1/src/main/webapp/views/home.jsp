<%@ page isELIgnored="false" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head><title>Library</title></head>
<body>
    <h2>Book List</h2>
    <table border="1">
        <tr><th>ID</th><th>Title</th><th>Author</th><th>Year</th></tr>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.id}</td>
                <td>${book.title}</td>
                <td>${book.author}</td>
                <td>${book.year}</td>
            </tr>
        </c:forEach>
    </table>
    <a href="add">Add New Book</a>
</body>
</html>