<<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>productFormAdd</title>
</head>
<body>
<form method="post" name="add" action="${pageContext.request.contextPath}/productAdd">
    <p class="select">
        Product  <br> <br> <br>
    <table>
    <tr>
        <th>Product id</th>
        <th>Product name</th>
        <th>Product cost</th>
        <th>Product discount</th>
        <th>Product description</th>
    </tr>
    <tr>
        <td>
            <label>
                <textarea name="id"></textarea>
            </label>
        </td>
        <td>
            <label>
                <textarea name="name"></textarea>
            </label>
        </td>
        <td>
            <label>
                <textarea name="cost"></textarea>
            </label>
        </td>
        <td>
            <label>
                <textarea name="discount"></textarea>
            </label>
        </td>
        <td>
            <label>
                <textarea name="description"></textarea>
            </label>
        </td>
    </tr>
</table>
    <p><input type="submit" name="submit_btn" value="Submit"></p>
</form>
</body>
</html>
