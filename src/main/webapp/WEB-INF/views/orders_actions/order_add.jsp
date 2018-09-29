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
<%--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">--%>


<html>
<head>
    <title>Dodaj Zadanie</title>
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
    <h5>Dodaj Zadanie</h5>
    <form action="/orderAdd" method="post">

        <p>
            Data przyjęcia zlecenia
            <br>
            <input matInput placeholder="Data przyjęcia zlecenia" type="date" name="dateOfAcceptance">
        </p>


        <p>
            Data planowanego startu
            <br>
            <input matInput placeholder="Data planowanego startu" type="date" name="dateOfPlanedStart">
        </p>
        <p>
            Data startu
            <br>
            <input matInput placeholder="Data startu" type="date" name="dateOfStart">
        </p>

        <p>
            Pracownik odpowiedzialny
            <br>
            <select name="employee">
                <c:forEach items="${allEmployee}" var="employee" varStatus="loopStatus">
                    <option value="${employee.id}">${employee.name}</option>
                </c:forEach>
            </select>
        </p>

        <p>
            Opis problemu
            <br>
            <input placeholder="Opis problemu" type="text" name="problemDescription">
        </p>
        <p>
            Opis rozwiązania
            <br>
            <input placeholder="Opis rozwiązania" type="text" name="repairDescription">
        </p>
        <p>
            Status
            <br>
            <select name="status">
                <c:forEach items="${status}" var="stat" varStatus="loopStatus">
                    <option value="${stat}">${stat}</option>
                </c:forEach>
            </select>
        <p>

        <p>
            Pojazd
            <br>
            <select name="vehicle">
                <c:forEach items="${vehicles}" var="vehicle" varStatus="loopStatus">
                    <option value="${vehicle.id}">${vehicle.licensePlate}</option>
                </c:forEach>
            </select>

        </p>

        <p>
            Wycena dla klienta
            <br>
            <input placeholder="Wycena dla klienta" type="text" name="costForClient">
        </p>

        <p>
            Ceny części zamiennych
            <br>
            <input placeholder="Ceny częśći zamiennych" type="text" name="partsCost">
        </p>
        <p>
            Poświęcone godziny
            <br>
            <input placeholder="Opis rozwiązania" type="number" name="numberOfHours">
        </p>


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
