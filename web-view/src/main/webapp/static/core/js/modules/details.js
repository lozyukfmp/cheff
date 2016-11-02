define(['require', 'jquery', 'ajax', 'edit'], function(require, $, ajax, edit) {

    var itemContainer = $("div.col-md-5:first > div.list-group");
    var detailsContainer = $("div.col-md-5:last");
    
    var showFunctions = {
        "menu": showMenuDetails,
        "salad": showSaladDetails,
        "vegetable": showVegetableDetails
    };

    var emptyObjects = {
        "menu": {
            name: "",
            saladList: []
        },
        "salad": {
            name: "",
            ingredients: []
        },
        "vegetable": {
            name: "",
            calories: undefined,
            fats: undefined,
            proteins: undefined,
            carbohydrates: undefined
        }
    };

    function showItemList(itemType, itemList) {
        itemContainer.empty();
        detailsContainer.empty();

        $.each(itemList, function (index, item) {

            var menuItemLink = $("<a href='#' class='list-group-item'></a>")
                .text(item.name);

            menuItemLink.click(function () {
                require('ajax').getItem(itemType, item);
            });

            itemContainer.append(menuItemLink);
        });

        addCreateButton(itemType, emptyObjects[itemType]);
    }

    function showVegetableDetails(vegetable) {
        detailsContainer.empty();

        detailsContainer.append(
            "<table class='table table-hover'>" +
                "<tbody>" +
                    "<tr><td><b>Name: </b></td><td>" + vegetable.name + "</td></tr>" +
                    "<tr><td><b>Calories: </b></td><td>" + vegetable.calories + "</td></tr>" +
                    "<tr><td><b>Fats: </b></td><td>" + vegetable.fats + "</td></tr>" +
                    "<tr><td><b>Proteins: </b></td><td>" + vegetable.proteins + "</td></tr>" +
                    "<tr><td><b>Carbohydrates: </b></td><td>" + vegetable.carbohydrates + "</td></tr>" +
                "</tbody>" +
            "</table>");

        addEditButtons("vegetable", vegetable);
    }

    function showSaladDetails(salad) {
        detailsContainer.empty();
        detailsContainer
            .append($("<p><b>Name: </b>" + salad.name + "</p>"));
        detailsContainer
            .append($("<p><b></b></p>").text("Ingredients : "));

        var $list = $("<div class='list-group'></div>");
        $.each(salad.ingredients, function(index, vegetable){
            $list.append($("<a href='#' class='list-group-item'></a>").text(vegetable.name));
        });

        detailsContainer.append($list);

        addEditButtons("salad", salad);
    }

    function showMenuDetails(menu) {
        detailsContainer.empty();
        detailsContainer
            .append($("<p></p>").text("Name : " + menu.name));
        detailsContainer
            .append($("<p></p>").text("Salads : "));

        var $list = $("<div class='list-group'></div>");
        $.each(menu.saladList, function(index, salad){
            $list.append($("<a href='#' class='list-group-item'></a>").text(salad.name));
        });

        detailsContainer.append($list);

        addEditButtons("menu", menu);
    }

    function addEditButtons(itemType, item) {
        var $buttonContainer = $("<div class='btn-group'></div>");

        var $editButton = $("<button class='btn btn-primary'></button>").text("Edit");
        var $deleteButton = $("<button class='btn btn-danger'></button>").text("Delete");

        $editButton.click(function () {
            edit.fillForm(itemType, item);
            edit.showModal();
        });

        $deleteButton.click(function () {
            require("ajax").deleteItem(itemType, item);
        });

        $buttonContainer.append($editButton, $deleteButton);
        detailsContainer.append($buttonContainer);
    }

    function addCreateButton(itemType, item) {
        var $buttonContainer = $("<div class='btn-group'></div>");

        var $createButton = $("<button class='btn btn-info' style='margin-top: 10px;'></button>").text("Create");

        $createButton.click(function () {
            edit.fillForm(itemType, item, "create");
            edit.showModal();
        });

        $buttonContainer.append($createButton);
        itemContainer.append($buttonContainer);
    }

    return {
        showItemList: showItemList,
        showDetails: function(name, item) {
            return showFunctions[name](item);
        }
    };
});