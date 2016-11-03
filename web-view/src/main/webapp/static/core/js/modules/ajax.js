define(['jquery', 'details', 'edit'], function ($, details, edit) {

    function getItemList(itemType, callback) {
        callback = callback || function (response) {
                details.showItemList(itemType, response);
            };
        
        $.ajax({
            url: itemType + "/all",
            success: function(response) {
                callback(response);
            }
        });
    }

    function getItem(itemType, item) {
        $.ajax({
            url: itemType + "/show/" + item.id,
            success: function (response) {
                details.showDetails(itemType, response);
            }
        });
    }

    function deleteItem(itemType, item) {
        $.ajax({
            url: itemType + "/delete/" + item.id,
            type: "POST",
            success: function () {
                getItemList(itemType);
            }
        });
    }

    function editItem(itemType, item, mode) {
        mode = mode || "edit";
        console.log("POSTING ITEM: ");
        console.log(item);
        $.ajax({
            url: itemType + "/" + mode,
            type: "POST",
            dataType: "json",
            data: JSON.stringify(item),
            beforeSend: function(xhr) {
                xhr.setRequestHeader("Accept", "application/json");
                xhr.setRequestHeader("Content-Type", "application/json");
            },
            success: function (response) {
                edit.closeModal();
                getItemList(itemType);
                getItem(itemType, response);
            }
        });
    }

    return {
        getItemList: getItemList,
        getItem: getItem,
        editItem: editItem,
        deleteItem: deleteItem
    };
});