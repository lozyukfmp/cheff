<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
    <div class="container" style="margin-top: 100px;">
        <div class="col-md-4 col-md-offset-2">
            <form action="/Controller" method="post">
                <input type="hidden" name="command" value="edit-salad"/>
                <input type="hidden" name="salad-id" value="${salad.id}"/>
                <div class="form-group">
                    <label for="salad-name">Название:</label>
                    <input type="text" class="form-control" name="salad-name"
                           value="${salad.name}" placeholder="Введите название салата" id="salad-name" required>
                </div>
                <button type="submit" class="btn btn-success">Изменить салат</button>
            </form>
            <br/>
            <div class="form-group">
                <label for="ingredients">Список добавленных ингредиентов(${fn:length(ingredientList)}):</label>
                <ul class="list-group" id="ingredients">
                    <c:forEach items="${ingredientList}" var="vegetable">
                        <form action="/Controller" method="post">
                            <input type="hidden" name="vegetable-id" value="${vegetable.id}"/>
                            <input type="hidden" name="salad-id" value="${salad.id}"/>
                            <input type="hidden" name="command" value="delete-ingredient-from-salad"/>
                            <a type="submit" href="" onclick="this.parentNode.submit(); return false;" class="list-group-item">
                                    ${vegetable.name}
                            </a>
                        </form>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-md-4 col-md-offset-2">
            <div class="form-group">
                <label for="vegetables">Список существующих овощей (${fn:length(vegetableList)}):</label>
                <ul class="list-group" id="vegetables">
                    <c:forEach items="${vegetableList}" var="vegetable">
                        <form action="/Controller" method="post">
                            <input type="hidden" name="vegetable-id" value="${vegetable.id}"/>
                            <input type="hidden" name="salad-id" value="${salad.id}"/>
                            <input type="hidden" name="command" value="add-ingredient-to-salad"/>
                            <a type="submit" href="" onclick="this.parentNode.submit(); return false;" class="list-group-item">
                                    ${vegetable.name}
                            </a>
                        </form>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
