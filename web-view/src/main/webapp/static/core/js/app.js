define(['jquery', 'ajax'], function ($, ajax) {
    
    function MenuItem(itemType){

        this.item = $("<a href='#' class='list-group-item'></a>").text(itemType);
        this.item.click(function () {
            ajax.getItemList(itemType);
        });

        this.getItem = function () {
            return this.item;
        }
    }

    return {
        init: function () {
            var parentContainer = $("div.col-md-2 > div.list-group");
            
            var menu = new MenuItem("menu");
            var salad = new MenuItem("salad");
            var vegetable = new MenuItem("vegetable");

            parentContainer.append(menu.getItem(), salad.getItem(), vegetable.getItem());
        }
    };
});
