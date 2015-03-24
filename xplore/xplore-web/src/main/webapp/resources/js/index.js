$(document).ready(function () {

    if($(".bxslider").length == 1){
        $('.bxslider').bxSlider({
            pagerCustom: '.bx-pager',
            pager:true,
            controls:false,
            auto:true
        });
    }



    $(".block-img-area").hover(function(){
        $(this).find(".overlay").toggleClass("hide")


    },function(){
        $(this).find(".overlay").toggleClass("hide")
    })

    $(".block-img-area").click(function(){

        var widget = $(".dropdown-menu-inner-wrapper").get($(this).attr("data-ref"));

        var url = $(widget).find(".article a:first").attr("href");

        window.location.href = url;

    })


    $(".block-item").hover(function(){
        $(this).css("color", "#FFFFFF")

    },function(){
        $(this).css("color", "#666666")
    })

    //var prevHeight = 0;
    //$(".detail-nav .detail-nav-item").each(function () {
    //
    //    var height = $(this).offset().top;
    //
    //    if (prevHeight != height && prevHeight != 0) {
    //
    //        $(this).prev().find("a").css("border-right", "1px solid transparent");
    //
    //    }
    //
    //    prevHeight = height;
    //
    //
    //})

    var totalWidth = 664;
    var currentWidth = 0;
    var tmp;
    var json = {};
    var xiabiao = 0;
    var array = new Array();
    $(".temp .detail-nav-item").each(function(idx, el){

        var width = $(this).width();

        tmp = width + currentWidth;
        if(tmp > 664){

            json[xiabiao++] = array;

            array = new Array();

            currentWidth = 0;

        }

        array.push(idx);

        currentWidth += width;

    });

    for(var x in json){

        var widthInOneLine = 664;

        var array = json[x];

        var widget = $("<div class='detail-nav'>");

        for(var i=0;i<array.length;i++){

            var index = array[i];

            var oneLine = $(".temp .detail-nav-item")[index];

            var oneWidth = $(oneLine).width();

            widget.append(oneLine);

            $(oneLine).removeClass("hide");

            widthInOneLine = widthInOneLine - oneWidth;

        }

        widget.appendTo(".detail-content");

        var size = array.length;

        var n = widthInOneLine / (size*2);

        var padding = "0 " + n + "px";

        widget.find(".detail-nav-item a").css("padding", padding)

    }




    $(".detail-nav .detail-nav-item:last").find("a").css("border-right", "1px solid transparent");

});