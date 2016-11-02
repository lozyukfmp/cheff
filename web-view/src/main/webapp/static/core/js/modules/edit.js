define(['require', 'jquery', 'ajax', 'bootstrap'], function (require, $, ajax) {
    var modal = $("#editModal");
    var $container = $(".modal-body");
    var $header = $(".modal-header");
    var $closeButton = $("#close-button");
    var initFormFunctions = {
        "vegetable": fillVegetableForm,
        "salad": fillSaladForm,
        "menu": fillMenuForm
    };

    function fillVegetableForm(vegetable, mode) {
        $container.empty();
        $header.empty();

        $header.append("<h3></h3>").text("Vegetable edit");
        
        var $form = $("<form role='form'></form>");
        $form.append($("<div class='form-group'></div>")
            .append($("<input type='text' id='name' class='form-control' placeholder='Name'/>").val(vegetable.name)))
            .append($("<div class='form-group'></div>")
                .append($("<input type='number' step='0.01' id='cal' class='form-control' placeholder='Calories'/>").val(vegetable.calories)))
            .append($("<div class='form-group'></div>")
                .append($("<input type='number' step='0.01' id='fats' class='form-control' placeholder='Fats'/>").val(vegetable.fats)))
            .append($("<div class='form-group'></div>")
                .append($("<input type='number' step='0.01' id='prtns'class='form-control' placeholder='Proteins'/>").val(vegetable.proteins)))
            .append($("<div class='form-group'></div>")
                .append($("<input type='number' step='0.01' id='cbn' class='form-control' placeholder='Carbohydrates'/>").val(vegetable.carbohydrates)))
            .append($("<button class='btn btn-success btn-block'/>").text("Edit"));

        $container.append($form);

        var $submit = $("button.btn-success");
        $submit.click(function () {
            require("ajax").editItem("vegetable", {
                id: vegetable.id,
                name: $("#name").val(),
                calories: $("#cal").val(),
                fats: $("#fats").val(),
                proteins: $("#prtns").val(),
                carbohydrates: $("#cbn").val()
            }, mode);
        });
    }

    function fillMenuForm(menu, mode) {
        $container.empty();
        $header.empty();

        $header.append("<h3></h3>").text("Menu edit");
        
        var $wrapper = $("<div class='container-fluid' style='margin-top: 10px;'></div>");
        var $form = $("<form role='form'></form>");
        $form.append($("<div class='form-group'></div>")
            .append($("<input type='text' id='name' class='form-control' placeholder='Name'/>").val(menu.name)));

        var $div = $("<div class='form-group col-md-6'></div>");

        var addedSaladNames = [];

        var $addedContainer = $("<div class='panel panel-default'>" +
            "<div class='panel-heading'></div>" +
            "<div class='panel-body'></div></div>");

        var $existContainer = $addedContainer.clone();

        var $addedSaladList = $("<ul class='list-group'></ul>");
        $.each(menu.saladList, function(index, salad) {
            $addedSaladList.append($("<a href='#' class='list-group-item'></a>")
                .text(salad.name)
                .data("id", salad.id));
            
            addedSaladNames.push(salad.name);
        });

        var $existSaladList = $("<ul class='list-group'></ul>");
        require("ajax").getItemList("salad", function (saladList) {
            $.each(saladList, function (index, salad) {
                if(addedSaladNames.indexOf(salad.name) < 0) {
                    $existSaladList.append($("<a href='#' class='list-group-item'></a>")
                        .text(salad.name)
                        .data("id", salad.id));
                }
            });
        });

        $addedSaladList.on("click", "a", function () {
            $existSaladList.append($(this).clone(true));
            $(this).remove();
        });

        $existSaladList.on("click", "a", function () {
            $addedSaladList.append($(this).clone(true));
            $(this).remove();
        });
    
        var $submit = $("<button class='btn btn-success btn-block'/>").text("Edit");
        $submit.click(function () {

            var salads = [];
            
            $addedSaladList.children().each(function () {
                salads.push({
                    id: $(this).data("id"),
                    name: $(this).text(),
                    ingredients: []
                });
            });
           
            require("ajax").editItem("menu", {
                id: menu.id,
                name: $("#name").val(),
                saladList: salads
            }, mode);
        });

        $form.append($submit);
        $container.append($form);
        
        $addedContainer.find(".panel-heading").append($("<b></b>").text("Added salad list:"));
        $addedContainer.find(".panel-body").append($addedSaladList);

        $existContainer.find(".panel-heading").append($("<b></b>").text("Salad list:"));
        $existContainer.find(".panel-body").append($existSaladList);

        $wrapper.append($div.clone().append($addedContainer), $div.clone().append($existContainer));
        $container.append($wrapper);
    }

    function fillSaladForm(salad, mode) {
        $container.empty();
        $header.empty();

        $header.append("<h3></h3>").text("Salad edit");
        
        var $wrapper = $("<div class='container-fluid' style='margin-top: 10px;'></div>");
        var $form = $("<form role='form'></form>");
        $form.append($("<div class='form-group'></div>")
            .append($("<input type='text' id='name' class='form-control' placeholder='Name'/>").val(salad.name)));

        var $div = $("<div class='form-group col-md-6'></div>");

        var addedVegetablesNames = [];

        var $addedContainer = $("<div class='panel panel-default'>" +
            "<div class='panel-heading'></div>" +
            "<div class='panel-body'></div></div>");

        var $existContainer = $addedContainer.clone();

        var $addedVegetableList = $("<ul class='list-group'></ul>");
        $.each(salad.ingredients, function(index, vegetable) {
            $addedVegetableList.append($("<a href='#' class='list-group-item'></a>")
                .text(vegetable.name)
                .data("id", vegetable.id));

            addedVegetablesNames.push(vegetable.name);
        });

        var $existVegetableList = $("<ul class='list-group'></ul>");
        require("ajax").getItemList("vegetable", function (vegetableList) {
            $.each(vegetableList, function (index, vegetable) {
                if(addedVegetablesNames.indexOf(vegetable.name) < 0) {
                    $existVegetableList.append($("<a href='#' class='list-group-item'></a>")
                        .text(vegetable.name)
                        .data("id", vegetable.id));
                }
            });
        });

        $addedVegetableList.on("click", "a", function () {
            $existVegetableList.append($(this).clone(true));
            $(this).remove();
        });

        $existVegetableList.on("click", "a", function () {
            $addedVegetableList.append($(this).clone(true));
            $(this).remove();
        });

        var $submit = $("<button class='btn btn-success btn-block'/>").text("Edit");
        $submit.click(function () {

            var vegetables = [];

            $addedVegetableList.children().each(function () {
                vegetables.push({
                    id: $(this).data("id"),
                    name: $(this).text()
                });
            });
            

            require("ajax").editItem("salad", {
                id: salad.id,
                name: $("#name").val(),
                ingredients: vegetables
            }, mode);
        });

        $form.append($submit);
        $container.append($form);

        $addedContainer.find(".panel-heading").append($("<b></b>").text("Ingredient list:"));
        $addedContainer.find(".panel-body").append($addedVegetableList);

        $existContainer.find(".panel-heading").append($("<b></b>").text("Vegetable list:"));
        $existContainer.find(".panel-body").append($existVegetableList);

        $wrapper.append($div.clone().append($addedContainer), $div.clone().append($existContainer));
        
        $container.append($wrapper);
    }

    return {
        fillForm: function (itemType, item, mode) {
            initFormFunctions[itemType](item, mode);
        },
        closeModal: function() {
            modal.modal('hide');
        },
        showModal: function() {
            modal.modal('show');
        }
    };
});
