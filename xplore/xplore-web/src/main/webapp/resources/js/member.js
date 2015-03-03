$(document).ready(function () {

    var info = {};
    info.currentUrl = window.app.cPath + "/member/list";
    info.info = {
        process: function (url) {

            $(".pt-tab .info-wrapper").removeClass("hide")

            $(".pt-tab .info-wrapper .content").load(url, function () {

                $("#datetimepicker").datetimepicker({
                    lang: 'ch',
                    format: 'Y-m-d',
                    timepicker: false,
                    closeOnDateSelect: true
                });

            });

        }

    }
    info.points = {
        process: function (url) {
            info.points.reset();

            var thisWrapper = info.points.show();

            // 这里根据不同的情况加载不同的内容，这段代码只会执行一次
            thisWrapper.find(".content tbody").load(url, function () {

                var maxPage = $(this).find(".max-page td").text();

                info.points.doPaging(url, maxPage);

            })
        },


        show: function () {
            return $(".pt-tab .points-wrapper").removeClass("hide");
        },
        doPaging: function (url, maxPage) {

            var pageEl = $(".points-wrapper .pagination");

            pageEl.find("input").data("current-page", 1);

            var paginationOptions = {
                max_page: maxPage,
                page_string: '当前第{current_page}页,' +
                '共{max_page}页',
                paged: function (page) {

                    var currentUrl = url + "&p=" + page;

                    $(".points-wrapper .content .points-table tbody").load(currentUrl, function () {
                    })
                }
            };

            pageEl.jqPagination(paginationOptions);
        },
        reset: function () {

            $('.points-wrapper .pagination').unbind();
            $(".points-wrapper .content .points-table tbody").html("");
            $(".points-wrapper .pagination input").attr("current_page", 1);
        }
    };
    info.coupon = {
        process: function (url) {
            info.coupon.reset();

            var thisWrapper = info.coupon.show();

            // 这里根据不同的情况加载不同的内容，这段代码只会执行一次
            thisWrapper.find(".content tbody").load(url, function () {

                var maxPage = $(this).find(".max-page td").text();

                info.coupon.doPaging(url, maxPage);

            })
        },
        show: function () {
            return $(".pt-tab .coupon-wrapper").removeClass("hide");
        },
        doPaging: function (url, maxPage) {

            var pageEl = $('.coupon-wrapper .pagination');

            pageEl.find("input").data("current-page", 1);

            var paginationOptions = {
                max_page: maxPage,
                page_string: '当前第{current_page}页,共{max_page}页',
                paged: function (page) {

                    var currentUrl = url + "&p=" + page;

                    $(".coupon-wrapper .content .coupon-table tbody").load(currentUrl, function () {
                    })
                }
            };

            pageEl.jqPagination(paginationOptions);
        },
        reset: function () {

            $('.coupon-wrapper .pagination').unbind();
            $(".coupon-wrapper .content .coupon-table tbody").html("");
            $(".coupon-wrapper .pagination input").attr("current_page", 1);
        }
    };

    // 主页面分页
    var paginationOptions = {
        current_page: $(".member").attr("data-p"),
        max_page: $(".member").attr("data-s"),
        page_string: '当前第{current_page}页,共{max_page}页',
        paged: function (page) {

            var currentUrl = "member/list?p=" + page;

            window.location.href = window.app.cPath + "/" + currentUrl;

        }
    };

    $(".member-list.pagination").jqPagination(paginationOptions);


    // 打开事件，注入id，默认选中第一个
    $(".show-detail").click(function () {
        info.currentMemberId = $(this).attr("data-ref");
        $(".member-detail").toggleClass("hide");

        $(".pt-tab .tab li:first").trigger("click");

    })

    // 关闭事件，重置所有数据
    $(".close").click(function () {
        // 关闭窗口
        $(".member-detail").toggleClass("hide");
        // 重置窗口为第一个
    })

    var handleTabClick = function () {

        $(".pt-tab .tab li").removeClass("selected");
        $(this).addClass("selected");

        $(".pt-tab .template").addClass("hide");

        var op = $(this).attr("data-op");

        // 这里开始处理其他
        var id = info.currentMemberId;

        var url = info.currentUrl + "?op=" + op + "&memberId=" + id;

        info[op].process(url);


    };

    $(".pt-tab .tab li").bind("click", handleTabClick);

    $(".edit-confirm").click(function () {


        $.post(window.app.cPath + "/member/edit", $("#edit-form").serialize(), function (response) {

            if (response.respCode != "00") {
                protops.base.hint(response.msg);
                return;
            }
            protops.base.hint("编辑成功");

            $(".add-admin").toggleClass("hide");

            protops.base.refreshPage("member/list");

        })


    })

});