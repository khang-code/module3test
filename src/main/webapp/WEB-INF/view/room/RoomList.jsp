<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/6/2024
  Time: 10:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Room Rental List</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #f5f5f5;
      margin: 0;
      padding: 0;
    }

    h2 {
      text-align: center;
      color: #333;
      margin-top: 20px;
    }

    /* Search form styling */
    form {
      display: flex;
      justify-content: center;
      margin: 20px;
    }

    form input[type="text"] {
      width: 300px;
      padding: 8px;
      border: 1px solid #ccc;
      border-radius: 5px 0 0 5px;
    }

    form input[type="submit"] {
      padding: 8px 20px;
      border: none;
      background-color: #4CAF50;
      color: white;
      cursor: pointer;
      border-radius: 0 5px 5px 0;
    }

    /* Table styling */
    table {
      width: 80%;
      margin: 20px auto;
      border-collapse: collapse;
      background-color: white;
      box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
    }

    th, td {
      padding: 12px;
      text-align: center;
      border-bottom: 1px solid #ddd;
    }

    th {
      background-color: #4CAF50;
      color: white;
    }

    /* Responsive design */
    @media (max-width: 600px) {
      table, form {
        width: 100%;
      }

      form input[type="text"], form input[type="submit"] {
        width: 100%;
        margin-bottom: 10px;
        border-radius: 5px;
      }
    }
  </style>
</head>
<body>

<h2>Available Rooms</h2>

<!-- Search form -->
<form action="/rooms" method="get">
  <input type="text" name="searchByName" placeholder="Search by room name">
  <input type="submit" value="Search">
</form>

<!-- Room list table -->
<table>
  <tr>
    <th>Room ID</th>
    <th>Name</th>
    <th>Description</th>
    <th>Price</th>
  </tr>
  <c:forEach var="room" items="${rooms}">
    <tr>
      <td>${room.id}</td>
      <td>${room.name}</td>
      <td>${room.description}</td>
      <td>${room.price} VND</td>
    </tr>
  </c:forEach>
</table>

</body>
</html>
