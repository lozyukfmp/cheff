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
        <table class="table">
            <tr>
                <td>Название:</td>
                <td>${vegetable.name}</td>
            </tr>
            <tr>
                <td>Калории:</td>
                <td>${vegetable.calories}</td>
            </tr>
            <tr>
                <td>Жиры:</td>
                <td>${vegetable.fats}</td>
            </tr>
            <tr>
                <td>Белки:</td>
                <td>${vegetable.proteins}</td>
            </tr>
            <tr>
                <td>Углеводы:</td>
                <td>${vegetable.carbohydrates}</td>
            </tr>
        </table>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="../../../js/bootstrap.min.js"></script>
</body>
</html>
