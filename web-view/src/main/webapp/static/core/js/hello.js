/**
 * Created by Артём on 30.10.2016.
 */
$(document).ready(function () {
    
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

    var menuProcessor = new EntityProcessor("menu", menuLink, centerContainer, rightContainer, entityFormer.formMenu);
    var saladProcessor = new EntityProcessor("salad", saladLink, centerContainer, rightContainer, entityFormer.formSalad);
    var vegetableProcessor = new EntityProcessor("vegetable", vegetableLink, centerContainer, rightContainer, entityFormer.formVegetable);
    
    linkContainer.append(menuLink);
    linkContainer.append(saladLink);
    linkContainer.append(vegetableLink);
});