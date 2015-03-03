package com.xplore.web.constants;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by damen on 2014/10/14.
 */
public class ResponseCodes {

    private static final String RESOURCE_NAME = "i18n/messageResources";

    public static final String KEY_PARAMS_ERROR = "key_params_error";

    public static final String KEY_LOGIN_AUTH_ERR = "key_login_auth_err";

    public static final String KEY_PERMISSION_ERR = "key_permission_err";

    public static final String KEY_EDIT_ADMIN_FAILED = "key_edit_admin_failed";

    public static final String KEY_RESET_PWD_FAILED = "key_reset_pwd_failed";

    public static final String KEY_DEL_ADMIN_FAILED = "key_del_pwd_failed";

    public static final String KEY_EDIT_MEMBER_FAILED = "key_edit_member_failed";

    public static final String KEY_STATS_IN_SILENCE = "key_stats_in_silence";


    public static String getMsg(String key, Object... placeHolder) {
        String msg = ResourceBundle.getBundle(RESOURCE_NAME, Locale.CHINESE).getString(key);
        if(0 == placeHolder.length){
            return msg;
        }
        return MessageFormat.format(msg, placeHolder);
    }
}
