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

    <title>Lista kientów</title>
</head>
<body>
<%@ include file="../footer_header/header.jspf" %>

<h5>Lista klientów</h5>

<form action="/clientList" method="post">
    <mat-form-field class="example-full-width">
        <input placeholder="Wyszukaj po nazwisku" type="text" name="search">
    </mat-form-field>

        <input type="submit" class="waves-effect waves-light btn" value="Szukaj">

</form>

<table width="50%" border="1">

    <tr align="left">
        <th width="5%">
            No
        </th>
        <th>
            Imię
        </th>
        <th>
            Nazwisko
        </th>
        <th>
            Data urodzin
        </th>
        <th width="8%">

        </th>

        <th width="8%">

        </th>
        <th width="8%">

        </th>
        <th width="8%">
        </th>

    </tr>


    <c:forEach items="${customers}" var="customer" varStatus="loopStatus">

        <tr>
            <td>
                    ${loopStatus.count}
            </td>
            <td>
                    ${customer.name}
            </td>
            <td>
                    ${customer.surname}
            </td>
            <td>
                    ${customer.birthDay}
            </td>

            <td>
                <a href="/vehicleList?id=${customer.id}" class="waves-effect waves-light btn">Pojazdy</a>
            </td>

            <td>
                <a href="/orderList?id=${customer.id}" class="waves-effect waves-light btn">Zlecenia</a>
            </td>

            <td>
                <a href="/clientEdit?id=${customer.id}" class="waves-effect waves-light btn">Edytuj</a>

            </td>
            <td>
                <a href="/clientDel?id=${customer.id}" class="waves-effect waves-light btn">Usuń</a>
            </td>

        </tr>

    </c:forEach>

</table>
<br>
<center>

    <a href="/clientAdd" class="waves-effect waves-light btn">Dodaj klienta</a>

</center>

<br>

<%@ include file="../footer_header/footer.jspf" %>
</body>
</html>
