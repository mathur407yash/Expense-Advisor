<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Expense</title>
</head>
<body>
<h2>Add Expense</h2>

<form action="/expenses/addExpense" method="post">
    Description: <input type="text" name="description" required><br><br>
    Amount: <input type="number" name="amount" step="0.01" required><br><br>
    <button type="submit">Save Expense</button>
</form>

<br>
<a href="/expenses/view">Back to Expense List</a>
</body>
</html>
