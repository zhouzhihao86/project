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

});