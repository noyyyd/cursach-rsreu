<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<meta charset="UTF-8" lang="ru">
<html>
<head>
    <title> Издательство</title>
    <style type="text/css">
        #shapka {
            width: 750px; /* Ширина блока и общая ширина*/
            height: 50px; /* Высота блока */
            margin-right: auto; /* Авто-отступ справа */
            margin-left: auto; /* Авто-отступ слева */
            padding: 10px; /* Внутренние поля вокруг содержимого */
            text-align: center;
            font-size: 40px;
            color: #030303;
            font-weight: 400;
            font-style: oblique;
        }

        #but {
            width: 150px;
            text-align: center;
            font-size: 17px;
            border-radius: 10px;
            background: rgb(172, 180, 180);
            opacity: 0.7;
            color: rgb(0, 0, 0);
            padding: 4px;
            border-radius: 6px;
            border: rgb(0, 0, 0);

        }

        #col1 {
            background: rgb(64, 138, 138);
            width: 350px;
            padding: 5px; /* Поля вокруг текста */
            margin-left: 5px; /* Отступ слева */
            margin-top: 2px; /* Отступ сверху */

            border: 1px solid rgb(0, 0, 0); /* Рамка вокруг слоя */
            border-radius: 6px;
        }

        #col3 {
            background: rgb(64, 138, 138);
            width: auto;
            padding: 5px; /* Поля вокруг текста */
            margin-left: 100px; /* Отступ слева */
            margin-top: 2px; /* Отступ сверху */
            float: left; /* Состыковка колонок по горизонтали */
            border: 1px solid black; /* Рамка вокруг слоя */
            border-radius: 6px;
        }

        #col2 {
            background: rgb(64, 138, 138);
            width: 350px;
            padding: 5px; /* Поля вокруг текста */
            margin-left: 5px; /* Отступ слева */
            margin-top: 5px; /* Отступ сверху */
            float: left; /* Состыковка колонок по горизонтали */
            border: 1px solid black; /* Рамка вокруг слоя */
            border-radius: 6px;

        }

        legend {
            text-align: center;
            font-size: 25px;
        }

        label {
            display: block;
            float: left;
            width: 100px;
            height: 15px;
        }

        p {
            font-size: 15px;
        }
    </style>
</head>
<body background="D:\stud\four\coursework\book.jpg">

<div id="shapka"> Издательство</div>
<div id="col1">
    <form>
        <legend> Удалить данные об авторе</legend>
        <p><label for="name1"></label>
            Введите фамилию автора
            <input type="nvatchar(100)" id="name1" name="lastName">
        </p>
        <input type="hidden" name="command" value="authorDelete">
        <p><input id="but1" type="submit" value="Удалить"></p>
    </form>
</div>
<div id="col4">
    <form>
        <legend> Удалить данные о Книге</legend>
        <p><label for="name1"></label>
            Введите название книги
            <input type="nvatchar(100)" id="name8" name="title">
        </p>
        <input type="hidden" name="command" value="bookDelete">
        <p><input id="but4" type="submit" value="Удалить"></p>
    </form>
</div>
<div id="col6">
    <form>
        <legend> Удалить данные о Договоре</legend>
        <p><label for="name1"></label>
            Введите номер договора
            <input type="nvatchar(100)" id="name19" name="id">
        </p>
        <input type="hidden" name="command" value="contractDelete">
        <p><input id="but6" type="submit" value="Удалить"></p>
    </form>
</div>
<div id="col2"> <!-- форма вставки -->
    <form action="${pageContext.request.contextPath}/index" method="POST">
        <legend> Добавить нового автора</legend>
        <p><label for="name2">Фамилия</label><input type="nvatchar(100)" name="lastName" id="name2"></p>
        <p><label for="name3">Имя </label><input type="nvatchar(100)" name="name" id="name3"></p>
        <p><label for="name4">Отчество</label><input type="nvatchar(100)" name="patronymic" id="name4"></p>
        <p><label for="name5">Телефон</label><input type="nvatchar(100)" name="phone" id="name5"></p>
        <p><label for="name6">Серия паспорта</label><input type="nvatchar(50)" name="passportSeries" id="name6"></p>
        <p><label for="name7">Номер паспорта</label><input type="nvatchar(50)" name="passportNumber" id="name7"></p>
        <p><label for="email">E-mail</label><input type="email" name="email" id="email"></p>
        <input type="hidden" name="command" value="authorAdd">
        <p><input id="but2" type="submit" value="Добавить"></p>
    </form>
</div>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<div id="col5"> <!-- форма вставки -->
    <form action="${pageContext.request.contextPath}/index" method="POST">
        <legend> Добавить новую книгу</legend>
        <p><label for="name2">ID договора</label><input type="nvatchar(100)" name="contractNumber" id="name9"></p>
        <p><label for="name3">Название</label><input type="nvatchar(100)" name="title" id="name10"></p>
        <p><label for="name4">Тираж (шт)</label><input type="nvatchar(100)" name="circulation" id="name11"></p>
        <p><label for="name5">Дата выхода из печати</label><input type="nvatchar(100)" name="printDate" id="name12"></p>
        <p><label for="name6">Себестоимость</label><input type="nvatchar(50)" name="costPrice" id="name13"></p>
        <p><label for="name7">Цена продажи</label><input type="nvatchar(50)" name="cost" id="name14"></p>
        <p><label for="email">Гонорар</label><input type="nvatchar(50)" name="fee" id="email1"></p>
        <input type="hidden" name="command" value="bookAdd">
        <p><input id="but5" type="submit" value="Добавить"></p>
    </form>
</div>
<br>
<br>
<br>
<div id="col7"> <!-- форма вставки -->
    <form action="${pageContext.request.contextPath}/index" method="POST">
        <legend> Добавить новый договор</legend>
        <p><label for="name1">ID договора</label><input type="nvatchar(100)" name="id" id="name20"></p>
        <p><label for="name2">Дата заключения</label><input type="nvatchar(100)" name="dateOfConclusion" id="name15"></p>
        <p><label for="name3">Дата расторжения</label><input type="nvatchar(100)" name="terminationDate" id="name16"></p>
        <p><label for="name4">Срок (лет)</label><input type="nvatchar(100)" name="term" id="name17"></p>
        <p><label for="name5">Статус</label><input type="nvatchar(100)" name="status" id="name18"></p>
        <input type="hidden" name="command" value="contractAdd">
        <p><input id="but7" type="submit" value="Добавить"></p>
    </form>
</div>
<div id="col3"> <!-- вывод -->
    <form action="${pageContext.request.contextPath}/index" method="POST" style="text-align: center">
        <input type="hidden" name="command" value="enterData">
        <button type="submit" id="but3" name="command"> Вывести данные</button>
    </form>
</div>
<div>
    <table border="1"> <!-- авторы -->
        <c:forEach var="author" items="${authors}">
            <tr>
                <th><c:out value="${author.ID}"/></th>
                <th><c:out value="${author.name}"/></th>
                <th><c:out value="${author.lastName}"/></th>
                <th><c:out value="${author.patronymic}"/></th>
                <th><c:out value="${author.phone}"/></th>
                <th><c:out value="${author.passportSeries}"/></th>
                <th><c:out value="${author.passportNumber}"/></th>
                <th><c:out value="${author.email}"/></th>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <table border="1"> <!-- книги -->
        <c:forEach var="book" items="${books}">
            <tr>
                <th><c:out value="${book.ID}"/></th>
                <th><c:out value="${book.contractNumber}"/></th>
                <th><c:out value="${book.title}"/></th>
                <th><c:out value="${book.circulation}"/></th>
                <th><c:out value="${book.printDate}"/></th>
                <th><c:out value="${book.costPrice}"/></th>
                <th><c:out value="${book.cost}"/></th>
                <th><c:out value="${book.fee}"/></th>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <table border="1"> <!-- договоры -->
        <c:forEach var="contract" items="${contracts}">
            <tr>
                <th><c:out value="${contract.ID}"/></th>
                <th><c:out value="${contract.dateOfConclusion}"/></th>
                <th><c:out value="${contract.terminationDate}"/></th>
                <th><c:out value="${contract.term}"/></th>
                <th><c:out value="${contract.status}"/></th>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>