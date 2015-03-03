$(document).ready(function () {

    $(".pt-popup .close").click(function () {

        $(this).parent().toggleClass("hide");

    })


    $(".cell").live("click", function () {

        $(this).toggleClass("selected");

    })

    $(".del").click(function(){

        var id = $(this).attr("data-ref");

        if(!confirm("你确定要删除么？")){
            return false;
        }

        var resource = $(this).attr("data-model");

        var url = window.app.cPath + "/" + resource + "/del?id=";

        $.get(url + id, function(response){

            if (response.respCode != "00") {
                protops.base.hint(response.msg);
                return;
            }

            protops.base.hint("删除成功");

            protops.base.refreshPage(resource + "/list");

        })


    })

});