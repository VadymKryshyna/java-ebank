<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<body>
<br/>
<br/>Account
<br/>id: ${account.id}
<br/>title:${account.title}
<br/>balance:${account.balance}
<br/>
<br/><a href="person?id=${account.personId}">All account person</a>
<br/>
<br/>List all transaction on account
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
            <td><a href="removeTransaction?transactionId=${item.id}&accountId=${account.id}">remove</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br/>
<br/>Add transaction
<form action="addTransaction" method="post">
    <input type="hidden" name="accountId" value="${account.id}">
    <br/>Debit:<input type="text" placeholder="debit" name="debit" required="">
    <br/>Credit:<input type="text" placeholder="credit" name="credit" required="">
    <br/>Sum:<input type="text" placeholder="sum" name="sum" required="">
    <button type="submit">Add transaction</button>
</form>

<br/>
</body>
</html>