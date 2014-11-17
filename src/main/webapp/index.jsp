<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<br/>List client
<br/>
<br/>
<table border="2">
    <thead>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>address</td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${model}" >
        <tr>
            <td>${item.id}</td>
            <td><a href="person?id=${item.id}">${item.name}</a></td>
            <td>${item.address}</td>
            <td><a href="removePerson?id=${item.id}">remove</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<br/>
<form action="addPerson" method="post">
    <br/>Name:<input type="text" placeholder="name" name="personName" required="">
    <br/>Name:<input type="text" placeholder="address" name="personAddress" required="">
    <br/><button type="submit">Add person</button>
</form>
<br/>
<br/><a href="transaction">All transaction in bank</a>
<br/>
</body>
</html>