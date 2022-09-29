<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>productForm</title>
</head>
<body>
<form name="Choose" action="/by.it_academy/0.0.0-SNAPSHOT">
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
    <c:forEach items="${productData}" var="product">
        <tr>
            <td>
                <c:out value="${product.getId()}"/>
            </td>
            <td>
                <c:out value="${product.getName()}"/>
            </td>
            <td>
                <c:out value="${product.getCost()}"/>
            </td>
            <td>
                <c:out value="${product.getDiscount()}"/>
            </td>
            <td>
                <c:out value="${product.getDescription()}"/>
            </td>
        </tr>
    </c:forEach>
</table>
</form>
</body>
</html>