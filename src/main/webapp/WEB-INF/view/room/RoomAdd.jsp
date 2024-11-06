<%--
  Created by IntelliJ IDEA.
  User: DELL
  Date: 11/6/2024
  Time: 10:48 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add New Room</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            align-items: center;
        }

        h2 {
            color: #333;
            margin-top: 20px;
        }

        /* Form styling */
        .room-form {
            background-color: #fff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            width: 300px;
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        .room-form label {
            font-weight: bold;
        }

        .room-form input[type="text"],
        .room-form input[type="date"],
        .room-form select,
        .room-form textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            outline: none;
        }

        .room-form textarea {
            resize: vertical;
        }

        .room-form input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 10px;
            cursor: pointer;
            border-radius: 5px;
        }

        .room-form input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>

<h2>Add New Room</h2>

<form action="/rooms?action=add" method="post" class="room-form">
    <label for="ma_phong">Room Code (Unique)</label>
    <input type="text" id="ma_phong" name="ma_phong" required placeholder="Enter unique room code">

    <label for="ngay_bat_dau">Start Date</label>
    <input type="date" id="ngay_bat_dau" name="ngay_bat_dau" required>

    <label for="hinh_thuc_thanh_toan">Payment Type</label>
    <select id="hinh_thuc_thanh_toan" name="hinh_thuc_thanh_toan" required>
        <option value="Theo tháng">Monthly</option>
        <option value="Theo quý">Quarterly</option>
        <option value="Theo năm">Yearly</option>
    </select>

    <label for="ghi_chu">Notes</label>
    <textarea id="ghi_chu" name="ghi_chu" rows="4" placeholder="Optional notes"></textarea>

    <input type="submit" value="Add Room">
</form>

</body>
</html>
