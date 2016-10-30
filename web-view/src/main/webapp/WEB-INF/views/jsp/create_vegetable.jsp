<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Menu page</title>

    <!-- Bootstrap -->
    <link href="../../../css/bootstrap.min.css" rel="stylesheet">
    <style>
        .btn-link {
            color: black;
        }
    </style>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="container" style="margin-top: 100px;">
    <div class="col-md-4 col-md-offset-4">
        <form action="/Controller" method="post">
            <input type="hidden" name="command" value="create-vegetable"/>
            <div class="form-group">
                <label for="vegetable-name">Название:</label>
                <input type="text" class="form-control" name="vegetable-name"
                       value="${vegetable.name}" placeholder="Введите название овоща" id="vegetable-name">
            </div>
            <div class="form-group">
                <label for="vegetable-calories">Калории:</label>
                <input type="number" step="0.01" class="form-control" name="vegetable-calories"
                       value="${vegetable.calories}" placeholder="Введите кол-во калорий" id="vegetable-calories">
            </div>
            <div class="form-group">
                <label for="vegetable-fats">Жиры:</label>
                <input type="number" step="0.01" class="form-control" name="vegetable-fats"
                       value="${vegetable.fats}" placeholder="Введите кол-во жиров" id="vegetable-fats">
            </div>
            <div class="form-group">
                <label for="vegetable-proteins">Белки:</label>
                <input type="number" step="0.01" class="form-control" name="vegetable-proteins"
                       value="${vegetable.proteins}" placeholder="Введите кол-во белков" id="vegetable-proteins">
            </div>
            <div class="form-group">
                <label for="vegetable-carbohydrates">Углеводы:</label>
                <input type="number" step="0.01" class="form-control" name="vegetable-carbohydrates"
                       value="${vegetable.carbohydrates}" placeholder="Введите кол-во углеводов" id="vegetable-carbohydrates">
            </div>
            <button type="submit" class="btn btn-success">Добавить овощь</button>
        </form>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../../js/bootstrap.min.js"></script>
</body>
</html>
