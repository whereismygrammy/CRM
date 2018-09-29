<%--
  Created by IntelliJ IDEA.
  User: Edu
  Date: 26.09.2018
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="orders" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


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

<h5>Szczegóły samochodu</h5>
<div class="row">
    <div class="col s6 offset-s3">
        <div class="card">
            <table width="50%" border="1">

                <tr>
                    <td width="20%">
                        <b>Id</b>
                    </td>
                    <td>
                        ${vehicle.id}
                    </td>

                </tr>

                <tr>
                    <td width="20%">
                        <b>Model</b>
                    </td>
                    <td>
                        ${vehicle.model}
                    </td>
                </tr>

                <tr>
                    <td width="20%">
                        <b>Marka</b>
                    </td>
                    <td>
                        ${vehicle.brand}
                    </td>
                </tr>


                <tr>
                    <td width="20%">
                        <b>Wyprodukowany</b>
                    </td>
                    <td>
                        ${vehicle.productionYear}
                    </td>
                </tr>


                <tr>
                    <td width="20%">
                        <b>Tablica</b>
                    </td>
                    <td>
                        ${vehicle.licensePlate}
                    </td>
                </tr>


                <tr>
                    <td width="20%">
                        <b>Przegląd</b>
                    </td>
                    <td>
                        ${vehicle.nextTechnicalInspection}
                    </td>
                </tr>


            </table>
        </div>
    </div>
</div>

<c:if test="${fn:length(orders) > 0}">

    <h5>Naprawy</h5>
    <div class="row">
        <div class="col s6 offset-s3">
            <div class="card">
                <table width="50%" border="1">

                    <c:forEach items="${orders}" var="order" varStatus="loopStatus">
                        <tr>
                            <td>
                                    ${loopStatus.count}
                            </td>
                            <td>
                                    ${order.problemDescription}
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
                                <a href="/orderDetails?orderId=${order.id}"
                                   class="waves-effect waves-light btn">Szczegóły</a>
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
            </div>
        </div>
    </div>
</c:if>

<center>

    <a href="/orderEdit?orderId=${order.id}" class="waves-effect waves-light btn">Edytuj</a>
    <a href="/orderDel?orderId=${order.id}" class="waves-effect waves-light btn">Usuń</a>

</center>
<br>
<%@ include file="../footer_header/footer.jspf" %>
</body>
</html>
