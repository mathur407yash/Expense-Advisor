<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register | Expense Advisor</title>
</head>
<body>
<h2>Register</h2>

<form action="register" method="post">
    <label>Name:</label>
    <input type="text" name="name" required><br><br>

    <label>Email:</label>
    <input type="email" name="email" required><br><br>

    <label>Password:</label>
    <input type="password" name="password" required><br><br>

    <input type="submit" value="Register">
</form>

<br>
<a href="login">Already have an account? Login here</a>

<% if (request.getAttribute("error") != null) { %>
    <p style="color:red;"><%= request.getAttribute("error") %></p>
<% } %>
</body>
</html>
