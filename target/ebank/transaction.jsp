<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<br/><a href="index">All person</a>
<br/>
<br/>Add new Transaction
<form action="addTransaction" method="post">
    <%--<input type="hidden" name="personId" value="${person.id}">--%>
    <br/>Debit:<input type="text" placeholder="debit" name="debit" required="">
    <br/>Credit:<input type="text" placeholder="credit" name="credit" required="">
    <br/>Sum:<input type="text" placeholder="sum" name="sum" required="">
    <button type="submit">Add transaction</button>
</form>
<br/>
<br/>
<br/>
<br/>List all transaction
<table border="2">
    <thead>
    <tr>
        <td>id</td>
        <td>debit account id</td>
        <td>credit account id</td>
        <td>sum</td>
        <td></td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${model}" >
        <tr>
            <td>${item.id}</td>
            <td>${item.idAccountDebit}</td>
            <td>${item.idAccountCredit}</td>
            <td>${item.sumTransaction}</td>
            <td><a href="removeTransaction?transactionId=${item.id}">remove</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
</body>
</html>