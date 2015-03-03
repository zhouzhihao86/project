package com.xplore.web.utils;

import com.xplore.web.constants.ResponseCodes;
import com.xplore.web.domain.ajax.AjaxResponse;
import com.xplore.web.exception.AdminException;

/**
 * Created by damen on 2014/11/22.
 */
public class ResponseCodesHelper {

    public static void buildErrResponse(AdminException e, AjaxResponse ajaxResponse){

        ajaxResponse.setRespCode(e.getResponseCode());

        String msg = ResponseCodes.getMsg(e.getResponseCode(), e.getMessageKeys());

        ajaxResponse.setMsg(msg);

    }

}
