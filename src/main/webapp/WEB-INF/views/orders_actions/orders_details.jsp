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
    <style>
        div, body {
            margin: 10px;
            padding: 5px;
        }
    </style>

    <title>Szczegóły zlecenia</title>
</head>
<body>
<%@ include file="../footer_header/header.jspf" %>

<h5>Szczegóły zlecenia</h5>
<div class="row">
    <div class="col s6 offset-s3">
        <div class="card">
            <table width="50%" border="1">

                <tr>
                    <td width="20%">
                        <b>Id</b>
                    </td>
                    <td>
                        ${order.id}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Data zgłoszenia</bold>
                    </td>
                    <td>
                        ${order.dateOfAcceptance}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Planowany start</b>
                    </td>
                    <td>
                        ${order.dateOfPlanedStart}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Start</b>
                    </td>
                    <td>
                        ${order.dateOfStart}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Pracownik</b>
                    </td>
                    <td>
                        ${order.employee.name}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Opis problemu</b>
                    </td>
                    <td>
                        ${order.problemDescription}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Opis naprawy</b>
                    </td>
                    <td>
                        ${order.repairDescription}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Status</b>
                    </td>
                    <td>
                        ${order.status}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Pojazd</b>
                    </td>
                    <td>
                        ${order.vehicle.licensePlate}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Wycena dla klienta</b>
                    </td>
                    <td>
                        ${order.costForClient}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Koszt części</b>
                    </td>
                    <td>
                        ${order.partsCost}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Koszt robocizny</b>
                    </td>
                    <td>
                        ${order.workCost}
                    </td>
                </tr>


                <tr>
                    <td>
                        <b>Ilość godzin pracy</b>
                    </td>
                    <td>
                        ${order.numberOfHours}
                    </td>
                </tr>


            </table>
        </div>
    </div>
</div>

<center>

    <a href="/orderEdit?orderId=${order.id}" class="waves-effect waves-light btn">Edytuj</a>
    <a href="/orderDel?orderId=${order.id}" class="waves-effect waves-light btn">Usuń</a>

</center>
<br>
<%@ include file="../footer_header/footer.jspf" %>
</body>
</html>
