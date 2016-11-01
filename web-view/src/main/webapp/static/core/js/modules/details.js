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
            id: -1,
            name: "",
            saladList: []
        },
        "salad": {
            id: -1,
            name: "",
            ingredients: []
        },
        "vegetable": {
            id: -1,
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
        detailsContainer
            .append($("<p></p>").text("Name : " + vegetable.name))
            .append($("<p></p>").text("Calories : " + vegetable.calories))
            .append($("<p></p>").text("Fats : " + vegetable.fats))
            .append($("<p></p>").text("Proteins : " + vegetable.proteins))
            .append($("<p></p>").text("Carbohydrates : " + vegetable.carbohydrates));

        addEditButtons("vegetable", vegetable);
    }

    function showSaladDetails(salad) {
        detailsContainer.empty();
        detailsContainer
            .append($("<p></p>").text("Name : " + salad.name));
        detailsContainer
            .append($("<p></p>").text("Ingredients : "));

        $.each(salad.ingredients, function(index, vegetable){
            detailsContainer
                .append($("<p></p>").text("Name : " + vegetable.name));
        });

        addEditButtons("salad", salad);
    }

    function showMenuDetails(menu) {
        detailsContainer.empty();
        detailsContainer
            .append($("<p></p>").text("Name : " + menu.name));
        detailsContainer
            .append($("<p></p>").text("Salads : "));

        $.each(menu.saladList, function(index, salad){
            detailsContainer
                .append($("<p></p>").text("Name : " + salad.name));
        });

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

        var $createButton = $("<button class='btn btn-info'></button>").text("Create");

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