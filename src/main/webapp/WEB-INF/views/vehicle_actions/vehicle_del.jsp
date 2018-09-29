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
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
      rel="stylesheet">


<html>
<head>
    <title>Usunięto klienta</title>
    <style>
        div, body {
            margin: 10px;
            padding: 5px;
        }
    </style>

</head>
<body>
<%@ include file="../footer_header/header.jspf" %>
<div>
    <center>
        <i class="material-icons">
            directions_car
        </i><h6>Usunięto klienta i jego pojazdy</h6><br>
        <a href="/vehicleList?id=${customerId}" class="waves-effect waves-light btn">Wróć do listy</a>
    </center>
</div>
<%@ include file="../footer_header/footer.jspf" %>
</body>
</html>
</title>
</head>
<body>
</body>
</html>
