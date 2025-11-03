<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, com.yash.ExpenseAdvisor.model.Expense" %>
<html>
<head>
    <title>My Expenses | Expense Advisor</title>
</head>
<body>
<h2>My Expenses</h2>

<a href="addExpense">Add Expense</a> | 
<a href="${pageContext.request.contextPath}/logout">Logout</a>

<!-- 🔍 Search Form -->
<form action="${pageContext.request.contextPath}/expenses/search" method="get" style="margin-top: 10px;">
    <input type="text" name="keyword" placeholder="Search by description" />
    <button type="submit">Search</button>
    <a href="${pageContext.request.contextPath}/expenses/view">Clear</a>

</form>

<br/>

<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Description</th>
        <th>Amount</th>
        <th>Date</th>
        <th>Actions</th>
    </tr>

    <%
        List<Expense> expenses = (List<Expense>) request.getAttribute("expenses");
        if (expenses != null && !expenses.isEmpty()) {
            int index = 1;
            for (Expense e : expenses) {
    %>
    <tr>
        <td><%= index++ %></td>
        <td><%= e.getDescription() %></td>
        <td><%= e.getAmount() %></td>
        <td><%= e.getDate() %></td>
        <td>
            <a href="${pageContext.request.contextPath}/expenses/edit/<%= e.getId() %>">Edit</a>
            <a href="${pageContext.request.contextPath}/expenses/delete/<%= e.getId() %>"
               onclick="return confirm('Are you sure you want to delete this expense?');">Delete</a>
        </td>
    </tr>
    <%
            }
        } else {
    %>
    <tr><td colspan="5">No expenses found.</td></tr>
    <%
        }
    %>
</table>

</body>
</html>
