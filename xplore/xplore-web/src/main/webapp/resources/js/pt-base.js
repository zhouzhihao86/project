/**
 * Created by damen on 2014/10/14.
 */
var protops = {}
protops.base = {

    hint: function (msg) {
        $("#err-hint").text(msg).removeClass("hide");
        setTimeout(function () {
            $("#err-hint").addClass("hide");
        }, 3000);
    },
    refreshPage: function (url) {
        window.location.href = window.app.cPath + "/" + url;
    },
    send: function (url, params, successCallback) {

        var data = {};
        data.params = params;

        $.ajax({
            type: 'POST',
            url: url,
            data: JSON.stringify(data),
            contentType: 'application/json;charset=utf-8',
            timeout: 20000,
            success: function (response) {
                if (response.respCode != "00") {
                    protops.base.hint(response.msg);
                    return false;
                }
                successCallback(response.params);

            },
            error: function (xhr, type) {

            }
        })
    },
    isInteger: function (a) {
        var reg =  /^[0-9]*$/;
        return reg.test(a);
    }


}