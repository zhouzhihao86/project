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

    var prevHeight = 0;
    $(".detail-nav .detail-nav-item").each(function () {

        var height = $(this).offset().top;

        if (prevHeight != height && prevHeight != 0) {

            $(this).prev().find("a").css("border-right", "1px solid transparent");

        }

        prevHeight = height;


    })

    $(".detail-nav .detail-nav-item:last").find("a").css("border-right", "1px solid transparent");

});