define(['require', 'jquery', 'ajax', 'bootstrap'], function (require, $, ajax) {

    var modal = $("#editModal");
    var container = $(".modal-body");
    var closeButton = $("#close-button");

    var initFormFunctions = {
        "vegetable": fillVegetableForm,
        "salad": fillSaladForm,
        "menu": fillMenuForm
    };

    function fillVegetableForm(vegetable) {
        container.empty();

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

        container.append($form);

        var $submit = $("button.btn-success");
        $submit.click(function () {
            require("ajax").editItem("vegetable", {
                id: vegetable.id,
                name: $("#name").val(),
                calories: $("#cal").val(),
                fats: $("#fats").val(),
                proteins: $("#prtns").val(),
                carbohydrates: $("#cbn").val()
            });
        });
    }

    function fillMenuForm(menu) {

    }

    function fillSaladForm(salad) {

    }

    return {
        fillForm: function (itemType, item) {
            initFormFunctions[itemType](item);
        },
        closeModal: function() {
            closeButton.click();
        },
        showModal: function() {
            modal.modal();
        }
    };
});
