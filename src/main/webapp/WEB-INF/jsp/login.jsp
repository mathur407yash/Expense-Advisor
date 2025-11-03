<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login | Expense Advisor</title>
</head>
<body>
<h2>Login</h2>

<form action="login" method="post">
    <label>Email:</label>
    <input type="text" name="email" required><br><br>

    <label>Password:</label>
    <input type="password" name="password" required><br><br>

    <input type="submit" value="Login">
</form>

<br>
<a href="register">Don't have an account? Register here</a>

<% if (request.getAttribute("error") != null) { %>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>
</body>
</html>
