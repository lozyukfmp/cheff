/**
 * Created by Артём on 31.10.2016.
 */
$(document).ready(function () {
    var entityFormer = (function () {
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
                .append($("<button class='btn btn-success btn-block'/>").text("Edit"));

            editBody.append($form);

            $button = $("button.btn-success");
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

            $.each(menu.saladList, function(index, salad){
                secondContainer
                    .append($("<p></p>").text("Name : " + salad.name));
            });

            var editBody = $("#editModal div.modal-body");
            $("#editModal div.modal-body").empty();

            var $form = $("<form role='form'></form>");
            $form.append($("<div class='form-group'></div>")
                .append($("<input type='text' id='name' class='form-control' placeholder='Name'/>").val(menu.name)));

            var $div = $("<div class='form-group col-md-6'></div>");

            var $addedSaladList = $("<ul class='list-group'></ul>");
            $.each(menu.saladList, function(index, salad) {
                $addedSaladList.append($("<a href='#' class='list-group-item'></a>")
                    .text(salad.name)
                    .data("id", salad.id));
            });

            $addedSaladList.on("click", "a", function () {
                $existSaladList.append($(this).clone());
                $(this).remove();
            });

            var $existSaladList = $("<ul class='list-group'></ul>");
            $.ajax({
                url: "/salad/all",
                success: function (saladList) {
                    $.each(saladList, function(index, salad) {
                        $existSaladList.append($("<a href='#' class='list-group-item'></a>")
                            .text(salad.name)
                            .data("id", salad.id));
                    });
                }
            });

            $existSaladList.on("click", "a", function () {
                $addedSaladList.append($(this).clone());
                $(this).remove();
            });

            $form.append($("<button class='btn btn-success btn-block'/>").text("Edit"));

            editBody.append($form);
            editBody.append($div.clone().append($addedSaladList))
                .append($div.clone().append($existSaladList));


            $button = $("button.btn-success");
            $button.click(function () {
                var menu = {
                    id: menu.id,
                    name: $("#name").val(),
                    saladList: []
                };
                $.map($addedSaladList.children(), function(value) {
                    menu.saladList.push({
                        id: value.data("id"),
                        name: value.text()
                    });
                });
                $.ajax({
                    url: "/vegetable/edit",
                    type: "POST",
                    dataType: "json",
                    data: JSON.stringify(menu),
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

        var formSalad = function (salad, secondContainer) {
            secondContainer.empty();
            secondContainer
                .append($("<p></p>").text("Name : " + salad.name));
            secondContainer
                .append($("<p></p>").text("Vegetables : "));
            
            $.each(salad.ingredients, function(index, vegetable){
                secondContainer
                    .append($("<p></p>").text("Name : " + vegetable.name));
            });
        };
        
        return {
            formSalad: formSalad,
            formMenu: formMenu,
            formVegetable: formVegetable
        }
    })();
});