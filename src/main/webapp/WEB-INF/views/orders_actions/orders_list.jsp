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

    <title>Lista zleceń</title>
</head>
<body>
<%@ include file="../footer_header/header.jspf" %>

<h5>Lista zleceń</h5>

<table width="50%" border="1">

    <tr align="left">
        <th width="5%">
            No
        </th>
        <th>
            Przyjęcie zlecenia
        </th>
        <th>
            Planowany start
        </th>
        <th>
            Estymata
        </th>

        <th>
            Koszt
        </th>
        <th>
            Pracownik
        </th>
        <th width="8%">
            Status
        </th>

        <th width="8%">

        </th>
        <th width="8%">

        </th>
        <th width="8%">
        </th>

    </tr>


    <c:forEach items="${orders}" var="order" varStatus="loopStatus">

        <tr>
            <td>
                    ${loopStatus.count}
            </td>
            <td>
                    ${order.dateOfAcceptance}
            </td>
            <td>
                    ${order.dateOfPlanedStart}
            </td>
            <td>
                    ${order.numberOfHours} h
            </td>
            <td>
                    ${order.workCost} $
            </td>
            <td>
                    ${order.employee.name}
            </td>

            <td>
                    ${order.status}

            </td>

            <td>
                <a href="/orderDetails?orderId=${order.id}" class="waves-effect waves-light btn">Szczegóły</a>
            </td>

            <td>
                <a href="/orderEdit?orderId=${order.id}" class="waves-effect waves-light btn">Edytuj</a>

            </td>
            <td>
                <a href="/orderDel?orderId=${order.id}" class="waves-effect waves-light btn">Usuń</a>
            </td>

        </tr>

    </c:forEach>

</table>
<br>
<center>

    <a href="/orderAdd" class="waves-effect waves-light btn">Dodaj zlecenie</a>

</center>

<br>

<%@ include file="../footer_header/footer.jspf" %>
</body>
</html>
