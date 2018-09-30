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

    <title>Lista pojazdów</title>
</head>
<body>
<%@ include file="../footer_header/header.jspf" %>

<h5>Lista pojazdów</h5>

<table width="50%" border="1">

    <tr align="left">
        <th width="5%">
            No
        </th>
        <th>
            Marka
        </th>
        <th>
            Model
        </th>
        <th>
            Rok produkcji
        </th>
        <th>
            Tablica rejerstracji
        </th>
        <th>
            Następna kontrola
        </th>
        <th>
        </th>

        <th width="8%">
        </th>

    </tr>


    <c:forEach items="${vehicleList}" var="vehicle" varStatus="loopStatus">

        <tr>
            <td>
                    ${loopStatus.count}
            </td>
            <td>
                    ${vehicle.brand}
            </td>
            <td>
                    ${vehicle.model}
            </td>
            <td>
                    ${vehicle.productionYear}
            </td>
            <td>
                    ${vehicle.licensePlate}
            </td>
            <td>
                    ${vehicle.nextTechnicalInspection}
            </td>
            <td>
            <td>
                <a href="/vehicleDetails?vehicleId=${vehicle.id}" class="waves-effect waves-light btn">Historia</a>
            </td>
            <td>
                <a href="/vehicleDel?vehicleId=${vehicle.id}&customerId=${customerId}"
                   class="waves-effect waves-light btn">Usuń</a>
            </td>

        </tr>

    </c:forEach>

</table>
<br>
<center>
    <a href="/vehicleAdd?id=${customerId}" class="waves-effect waves-light btn">Dodaj pojazd</a>
</center>

<br>

<%@ include file="../footer_header/footer.jspf" %>
</body>
</html>
