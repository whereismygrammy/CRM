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

        <div class="col s4 offset-s4">
            <small>Wygenerowane dla okresu ${raportTimeCash.start} do ${raportTimeCash.end}</small>
        </div>

        <div class="col s4 offset-s4">
            <div class="card">

                <table>
                    <tr>
                        <td>
                            <center>
                                <h5>Kwota wystawionych faktur <br> ${raportTimeCash.cash} $</h5>
                            </center>
                        </td>
                    </tr>
                </table>

                <small>Raport pokazuje kwotę za zrealizowane zadania, pozyskane w zadanym okresie czasu.</small>

            </div>
        </div>


        <div class="col s4 offset-s4">
            <div class="card">


                <table>
                    <tr>
                        <td>
                            <b>
                                No
                            </b>
                        </td>
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
                    <c:forEach items="${raport1}" varStatus="i" var="row">
                        <tr>

                            <td>
                                    ${i.count}
                            </td>
                            <td>
                                    ${row[0]}
                            </td>
                            <td>
                                    ${row[1]}
                            </td>


                        </tr>

                    </c:forEach>


                </table>

                <small>Uproszczony raport liczy dane na podstawie zleceń użytkownika po dacie rozpoczęcia
                    projektu.
                </small>

            </div>
        </div>


        <div class="col s4 offset-s4">
            <div>
                <form action="/raports" method="post">

                    <table class="responsive-table">
                        <tr>
                            <td>
                                <label>Licz od</label>
                                <input type="date" name="raportStart">

                            </td>

                            <td>
                                <label>Licz do</label>
                                <input type="date" name="raportEnd">

                            </td>

                        </tr>

                        <tr>

                        </tr>

                    </table>

                    <br>
                    <button class="btn waves-effect waves-light" type="submit">Generuj
                        <i class="material-icons right">assignment </i>
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