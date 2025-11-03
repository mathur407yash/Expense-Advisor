<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Edit Expense</title></head>
<body>
<h2>Edit Expense</h2>

<form action="${pageContext.request.contextPath}/expenses/update" method="post">
    <input type="hidden" name="id" value="${expense.id}" />
	<input type="hidden" name="userEmail" value="${expense.userEmail}" />  <!-- ✅ Add this -->
	
    Description: <input type="text" name="description" value="${expense.description}" /><br>
    Amount: <input type="number" name="amount" value="${expense.amount}" /><br>
    Date: <input type="date" name="date" value="${expense.date}" /><br><br>

    <input type="submit" value="Update Expense" />
</form>
</body>
</html>
