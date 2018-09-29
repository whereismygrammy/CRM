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

<html>
<head>
    <title>Edytuj Zadanie</title>
    <style>
        div, body {
            margin: 5px;
            padding: 5px;
        }
    </style>

    <!-- CSS -->

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">


</head>
<body>


<%@ include file="../footer_header/header.jspf" %>

<center>
    <div class="row">
        <div class="col s6 offset-s3">
            <div class="card">
                <h5>Edytuj Zadanie</h5>

                <form action="/orderEdit" method="post">


                    <input type="date" name="dateOfAcceptance" value="${order.dateOfAcceptance}">
                    <label>Data przyjęcia zlecenia</label>


                    <input type="date" name="dateOfPlanedStart" value="${order.dateOfPlanedStart}">
                    <label>Data planowanego startu</label>

                    <input type="date" name="dateOfStart" value="${order.dateOfStart}">
                    <label>Data startu</label>

                    <select name="employee">
                        <option disabled selected>Zmień pracownika lub wybierz ponownie ${order.employee.name}</option>
                        <c:forEach items="${allEmployee}" var="employee" varStatus="loopStatus">
                            <option value="${employee.id}">${employee.name}</option>
                        </c:forEach>
                    </select>


                    <input type="text" name="problemDescription" value="${order.problemDescription}">
                    <label>Opis problemu</label>

                    <input type="text" name="repairDescription" value="${order.repairDescription}">
                    <label>Opis rozwiązania</label>

                    <select name="status">
                        <option disabled selected>Zmień status lub wybierz ponownie ${order.status}</option>
                        <c:forEach items="${status}" var="stat" varStatus="loopStatus">
                            <option value="${stat}">${stat}</option>
                        </c:forEach>
                    </select>

                    <select name="vehicle">
                        <option disabled selected>Zmień pojazd lub wybierz ponownie ${order.vehicle.licensePlate}
                        </option>
                        <c:forEach items="${vehicles}" var="vehicle" varStatus="loopStatus">
                            <option value="${vehicle.id}">${vehicle.licensePlate}</option>
                        </c:forEach>
                    </select>


                    <input type="text" name="costForClient" value="${order.costForClient}">
                    <label>Wycena dla klienta</label>

                    <input type="text" name="partsCost" value="${order.partsCost}">
                    <label>Ceny części zamiennych</label>

                    <input type="number" name="numberOfHours" value="${order.numberOfHours}">
                    <label>Poświęcone godziny</label>

                    <input class="hidden" type="text" name="orderId" value="${order.id}">


                    <br><br>
                    <button class=" btn waves-effect waves-light"
                            type="submit">Zapisz dane<i class="material-icons right">send</i>
                    </button>
                </form>
            </div>
        </div>
    </div>
</center>

<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.js"></script>
<script>
    M.AutoInit();

    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems, options);
    });

    document.addEventListener('DOMContentLoaded', function () {
        var elems = document.querySelectorAll('.datepicker');
        var instances = M.Datepicker.init(elems, options);
    });
</script>

<%@ include file="../footer_header/footer.jspf" %>

</body>
</html>