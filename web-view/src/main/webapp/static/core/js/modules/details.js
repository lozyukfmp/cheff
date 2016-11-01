define(['require', 'jquery', 'ajax'], function(require, $, ajax) {

    var itemContainer = $("div.col-md-5:first > div.list-group");
    var detailsContainer = $("div.col-md-5:last");
    
    var showFunctions = {
        "menu": showMenuDetails,
        "salad": showSaladDetails,
        "vegetable": showVegetableDetails
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
    }

    function showVegetableDetails(vegetable) {
        detailsContainer.empty();
        detailsContainer
            .append($("<p></p>").text("Name : " + vegetable.name))
            .append($("<p></p>").text("Calories : " + vegetable.calories))
            .append($("<p></p>").text("Fats : " + vegetable.fats))
            .append($("<p></p>").text("Proteins : " + vegetable.proteins))
            .append($("<p></p>").text("Carbohydrates : " + vegetable.carbohydrates));

        addEditButtons();
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

        addEditButtons();
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

        addEditButtons();
    }

    function addEditButtons() {
        detailsContainer.append("<div class='btn-group'>" +
        "<button type='button' class='btn btn-primary'>Edit</button>" +
            "<button type='button' class='btn btn-danger'>Delete</button>" +
            "</div>");

        var $editButton = $("<button class='btn btn-primary'></button>").text("Edit");
        var $deleteButton = $("<button class='btn btn-danger'></button>").text("Delete");

        $editButton.click(function () {

        });
    }

    return {
        showItemList: showItemList,
        showDetails: function(name, item) {
            return showFunctions[name](item);
        }
    };
});