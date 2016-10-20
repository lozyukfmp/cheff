<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>Index page</title>

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
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h3>Список меню:</h3>
            <table class="table">
                <colgroup>
                    <col class="col-md-3">
                    <col class="col-md-3">
                    <col class="col-md-3">
                    <col class="col-md-3">
                </colgroup>
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Просмотреть</th>
                    <th>Изменить</th>
                    <th>Удалить</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${menuList}" var="menu">
                    <tr>
                        <td class="col-md-3">${menu.name}</td>
                        <td class="col-md-3">
                            <form action="/Controller" method="get">
                                <input type="hidden" name="command" value="show-menu"/>
                                <input type="hidden" name="menu-id" value="${menu.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                        <td class="col-md-3">
                            <form action="/Controller" method="get">
                                <input type="hidden" name="command" value="get-edit-menu-page"/>
                                <input type="hidden" name="menu-id" value="${menu.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                        <td class="col-md-3">
                            <form action="/Controller" method="post">
                                <input type="hidden" name="command" value="delete-menu"/>
                                <input type="hidden" name="menu-id" value="${menu.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <form action="/Controller" method="get">
                            <input type="hidden" name="command" value="get-create-menu-page"/>
                            <button type="submit" class="btn btn-success">Добавить меню</button>
                        </form>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h3>Список салатов:</h3>
            <table class="table">
                <colgroup>
                    <col class="col-md-3">
                    <col class="col-md-3">
                    <col class="col-md-3">
                    <col class="col-md-3">
                </colgroup>
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Просмотреть</th>
                    <th>Изменить</th>
                    <th>Удалить</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${saladList}" var="salad">
                    <tr>
                        <td class="col-md-3">${salad.name}</td>
                        <td class="col-md-3">
                            <form action="/Controller" method="get">
                                <input type="hidden" name="command" value="show-salad"/>
                                <input type="hidden" name="salad-id" value="${salad.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                        <td class="col-md-3">
                            <form action="/Controller" method="get">
                                <input type="hidden" name="command" value="get-edit-salad-page"/>
                                <input type="hidden" name="salad-id" value="${salad.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                        <td class="col-md-3">
                            <form action="/Controller" method="post">
                                <input type="hidden" name="command" value="delete-salad"/>
                                <input type="hidden" name="salad-id" value="${salad.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <form action="/Controller" method="get">
                            <input type="hidden" name="command" value="get-create-salad-page"/>
                            <button type="submit" class="btn btn-success">Добавить салат</button>
                        </form>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
    <div class="row">
        <div class="col-md-6 col-md-offset-3">
            <h3>Список овощей:</h3>
            <table class="table">
                <colgroup>
                    <col class="col-md-3">
                    <col class="col-md-3">
                    <col class="col-md-3">
                    <col class="col-md-3">
                </colgroup>
                <thead>
                <tr>
                    <th>Название</th>
                    <th>Просмотреть</th>
                    <th>Изменить</th>
                    <th>Удалить</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${vegetableList}" var="vegetable">
                    <tr>
                        <td>${vegetable.name}</td>
                        <td>
                            <form action="/Controller" method="get">
                                <input type="hidden" name="command" value="show-vegetable"/>
                                <input type="hidden" name="vegetable-id" value="${vegetable.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                        <td class="col-md-3">
                            <form action="/Controller" method="get">
                                <input type="hidden" name="command" value="get-edit-vegetable-page"/>
                                <input type="hidden" name="vegetable-id" value="${vegetable.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                        <td class="col-md-3">
                            <form action="/Controller" method="post">
                                <input type="hidden" name="command" value="delete-vegetable"/>
                                <input type="hidden" name="vegetable-id" value="${vegetable.id}"/>
                                <button type="submit" class="btn btn-link">
                                    <span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
                                </button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
                <tfoot>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>
                        <form action="/Controller" method="get">
                            <input type="hidden" name="command" value="get-create-vegetable-page"/>
                            <button type="submit" class="btn btn-success">Добавить овощь</button>
                        </form>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>