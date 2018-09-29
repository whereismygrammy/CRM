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

    <title>Lista pracowników</title>
</head>
<body>
<%@ include file="../footer_header/header.jspf" %>
<h5>Lista pracowników</h5>

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
            Adres
        </th>
        <th>
            Telefon
        </th>
        <th>
            Notatka
        </th>
        <th>
            Koszt na godzinę
        </th>
        <th>
        </th>

    </tr>


    <c:forEach items="${employeers}" var="employee" varStatus="loopStatus">

        <tr>
            <td>
                    ${loopStatus.count}
            </td>
            <td>
                    ${employee.name}
            </td>
            <td>
                    ${employee.surname}
            </td>
            <td>
                    ${employee.address}
            </td>
            <td>
                    ${employee.phone}
            </td>
            <td>
                    ${employee.note}
            </td>
            <td>
                    ${employee.costPerHour}
            </td>

            <td>
                <a href="/employeeDel?id=${employee.id}" class="waves-effect waves-light btn">Usuń pracownika</a>

            </td>

        </tr>

    </c:forEach>

</table>
<br>
<center>
    <a href="/employeeAdd" class="waves-effect waves-light btn">Dodaj pracownika</a>
</center>

<br>

<%@ include file="../footer_header/footer.jspf" %>
</body>
</html>
