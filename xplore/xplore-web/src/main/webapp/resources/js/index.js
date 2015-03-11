$(document).ready(function () {

    $('.bxslider').bxSlider({
        pagerCustom: '.bx-pager',
        pager:true,
        controls:false,
        auto:true
    });



    $(".block-img-area").hover(function(){
        $(this).find(".overlay").toggleClass("hide")


    },function(){
        $(this).find(".overlay").toggleClass("hide")
    })

    $(".block-img-area").click(function(){
        window.location.href = window.app.cPath + "/web";
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