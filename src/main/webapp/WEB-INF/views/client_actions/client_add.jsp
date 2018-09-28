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


    </style>

</head>
<body>
<%@ include file="../footer_header/header.jspf" %>
<div>
        <h5>Dodaj użytkownika</h5>
    <form action="/clientAdd" method="post">
        <mat-form-field class="example-full-width">
            <input matInput placeholder="Imię" type="text" name="firstname">
        </mat-form-field>

        <mat-form-field class="example-full-width">

            <input type="text" placeholder="Nazwisko" name="lastname">
        </mat-form-field>


        <mat-form-field class="example-full-width">

            <input type="date" placeholder="Nazwisko" name="birthday">

        </mat-form-field>

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
