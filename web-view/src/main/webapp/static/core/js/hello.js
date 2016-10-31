/**
 * Created by Артём on 30.10.2016.
 */
$(document).ready(function () {

    var formVegetable = function (vegetable, secondContainer) {
        secondContainer.empty();
        secondContainer
            .append($("<p></p>").text("Name : " + vegetable.name))
            .append($("<p></p>").text("Calories : " + vegetable.calories))
            .append($("<p></p>").text("Fats : " + vegetable.fats))
            .append($("<p></p>").text("Proteins : " + vegetable.proteins))
            .append($("<p></p>").text("Carbohydrates : " + vegetable.carbohydrates));

        var editBody = $("#editModal div.modal-body");
        $("#editModal div.modal-body").empty();
        
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
            .append($("<button type='submit' class='btn btn-success btn-block'/>").text("Edit"));

        editBody.append($form);

        $button = $("button[type='submit']");
        $button.click(function () {
            var veg = {
                id: vegetable.id,
                name: $("#name").val(),
                calories: $("#cal").val(),
                fats: $("#fats").val(),
                proteins: $("#prtns").val(),
                carbohydrates: $("#cbn").val()
            };
            $.ajax({
                url: "/vegetable/edit",
                type: "POST",
                dataType: "json",
                data: JSON.stringify(veg),
                beforeSend: function(xhr) {
                    xhr.setRequestHeader("Accept", "application/json");
                    xhr.setRequestHeader("Content-Type", "application/json");
                },
                success: $("#edit-button").click()
            })
        });

        var editLink = $("<a href='#' class='list-group-item'></a>").text("Edit");
        var deleteLink = $("<a href='#' class='list-group-item'></a>").text("Delete");

        editLink.click(function () {
            $("#editModal").modal();
        });

        deleteLink.click(function () {

        });

        secondContainer.append(editLink);
        secondContainer.append(deleteLink);
    };

    var formMenu = function (menu, secondContainer) {
        secondContainer.empty();
        secondContainer
            .append($("<p></p>").text("Name : " + menu.name));
        secondContainer
            .append($("<p></p>").text("Salads : "));
        console.log(menu);
        $.each(menu.saladList, function(index, salad){
            secondContainer
                .append($("<p></p>").text("Name : " + salad.name));
        });
    };

    var formSalad = function (salad, secondContainer) {
        secondContainer.empty();
        secondContainer
            .append($("<p></p>").text("Name : " + salad.name));
        secondContainer
            .append($("<p></p>").text("Vegetables : "));
        console.log(salad);
        $.each(salad.ingredients, function(index, vegetable){
            secondContainer
                .append($("<p></p>").text("Name : " + vegetable.name));
        });
    };
    
    function EntityProcessor(urlBase, item, firstContainer, secondContainer, formEntity) {
        this.urlBase = urlBase;
        this.item = item;
        this.firstContainer = firstContainer;
        this.secondContainer = secondContainer;

        item.click(function () {
            secondContainer.empty();
            $.ajax({
                url: urlBase + '/all',
                success: function (entityList) {
                    firstContainer.empty();
                    $.each(entityList, function (index, entity) {

                        var menuItemLink = $("<a href='#' class='list-group-item'></a>")
                            .text(entity.name);
                        
                        menuItemLink.click(function () {
                             $.ajax({
                                 url: urlBase + "/show/" + entity.id,
                                 success: function(ent){
                                     formEntity(ent, secondContainer);
                                 }
                             });
                        });
                        firstContainer.append(menuItemLink);
                    });
                }
            });
        });
    }

    var linkContainer = $("div.col-md-2 > div.list-group");
    var centerContainer = $("div.col-md-5:first > div.list-group");
    var rightContainer = $("div.col-md-5:last");

    var menuLink = $("<a href='#' class='list-group-item'></a>").text("Menu");
    var saladLink = $("<a href='#' class='list-group-item'></a>").text("Salad");
    var vegetableLink = $("<a href='#' class='list-group-item'></a>").text("Vegetable");

    var menuProcessor = new EntityProcessor("menu", menuLink, centerContainer, rightContainer, formMenu);
    var saladProcessor = new EntityProcessor("salad", saladLink, centerContainer, rightContainer, formSalad);
    var vegetableProcessor = new EntityProcessor("vegetable", vegetableLink, centerContainer, rightContainer, formVegetable);
    
    linkContainer.append(menuLink);
    linkContainer.append(saladLink);
    linkContainer.append(vegetableLink);
});