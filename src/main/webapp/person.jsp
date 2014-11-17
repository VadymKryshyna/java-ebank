<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<br/>Client info
<br/>
<br/>Name: ${person.name}
<br/>Address: ${person.address}
<br/>
<table border="2">
    <thead>
    <tr>
        <td>id</td>
        <td>balance</td>
        <td>title</td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${model}" >
        <tr>
            <td>${item.id}</td>
            <td>${item.balance}</td>
            <td><a href="account?accountId=${item.id}">${item.title}</a></td>
            <td><a href="removeAccount?accountId=${item.id}&personId=${person.id}">remove</a> </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<br/>
<br/>
<form action="addAccount" method="post">
    <input type="hidden" name="personId" value="${person.id}">
    <br/>Title:<input type="text" placeholder="title" name="title" required="">
    <button type="submit">Add account</button>
</form>
<br/>
<br/><a href="index">All person</a>
<br/>
</body>
</html>