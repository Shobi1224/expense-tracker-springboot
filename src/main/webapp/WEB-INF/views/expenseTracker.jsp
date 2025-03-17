<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Expense Tracker</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h2>Expense Tracker</h2>

    <form action="addExpense" method="post">
        <label>Category:</label>
        <input type="text" name="category" required><br>
        <label>Amount:</label>
        <input type="number" name="amount" required><br>
        <label>Date:</label>
        <input type="date" name="date" required><br>
        <button type="submit">Add Expense</button>
    </form>

    <h3>Expense List</h3>
    <table border="1">
        <tr>
            <th>Category</th>
            <th>Amount</th>
            <th>Date</th>
            <th>Action</th>
        </tr>
        <c:forEach var="expense" items="${expenses}">
            <tr>
                <td>${expense.category}</td>
                <td>${expense.amount}</td>
                <td>${expense.date}</td>
                <td>
                    <form action="deleteExpense" method="post">
                        <input type="hidden" name="id" value="${expense.id}">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
