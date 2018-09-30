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
    <title>Dodaj Zadanie</title>
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
        <div class="col s4 offset-s1">
            <div class="card">
                <h5>Kutas 1</h5>

                <table>
                    <tr>
                        <td>
                            <b>
                                Imię i nazwisko pracownika
                            </b>
                        </td>
                        <td>
                            <b>
                                Ilość roboczo-godzin
                            </b>
                        </td>
                    </tr>
                    <c:forEach items="${employeers}" varStatus="i" var="employee">
                        <tr>
                            <td>
                                    ${employee.name} ${employee.surname}
                            </td>
                            <td>
                                kutas 18
                            </td>
                        </tr>


                    </c:forEach>


                </table>


            </div>
        </div>

        <div class="col s4 offset-s1">
            <div class="card">
                <h5>Kutas 2</h5>

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