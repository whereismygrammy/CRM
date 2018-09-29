<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 26.09.2018
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ page contentType="text/html;charset=UTF-8"
         language="java"
         isELIgnored="false" %>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<html>
<head>
    <title>Dodaj klienta</title>
    <style>
        div, body {
            margin: 5px;
            padding: 5px;
        }

        .hidden {
            display: none;
        }

    </style>

</head>
<body>
<%@ include file="../footer_header/header.jspf" %>
<div>
    <h5>Dodaj samochód</h5>
    <form action="/vehicleAdd" method="post">

        <mat-form-field class="example-full-width">
            <input matInput placeholder="Marka" type="text" name="brand">
        </mat-form-field>

        <mat-form-field class="example-full-width">
            <input type="text" matInput placeholder="Model" name="model">
        </mat-form-field>

        <mat-form-field class="example-full-width">
            <input type="text" matInput placeholder="Rok produkcji" name="productionYear">
        </mat-form-field>

        <mat-form-field class="example-full-width">
            <input type="text" matInput placeholder="Tablica rejerstracji" name="licensePlate">
        </mat-form-field>

        <mat-form-field class="example-full-width">
            <input type="date" matInput placeholder="Następna kontrola" name="nextTechnicalInspection">
        </mat-form-field>


        <input class="hidden" type="text" name="customerId" value="${customerId}">

        <center>

            <input type="submit" class="waves-effect waves-light btn">
        </center>

    </form>
</div>

<%@ include file="../footer_header/footer.jspf" %>
</body>
</html>
</title>
</head>
<body>
</body>
</html>
