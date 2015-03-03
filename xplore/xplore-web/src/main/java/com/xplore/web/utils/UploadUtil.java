package com.xplore.web.utils;

import com.xplore.web.constants.AdminConfig;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.OutputStream;

/**
 * Created by damen on 2014/12/22.
 */
public class UploadUtil {

    public static final String RES_PATH = "resources/img/uploads/";
    private static final String FILE_PLACEHOLDER = "myfile";

    public static String handleUpload(HttpServletRequest request) {

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;

        MultipartFile myfile = multipartRequest.getFile(FILE_PLACEHOLDER);

        String fileName = AdminConfig.get(AdminConfig.KEY_CONTEXT_PATH) + RES_PATH + myfile.getOriginalFilename();

        OutputStream output = null;
        try {
            output = new FileOutputStream(fileName);
            StreamUtil.copy(myfile.getInputStream(), output);
            return RES_PATH + myfile.getOriginalFilename();
        } catch (Exception e) {
        } finally {
            StreamUtil.closeQuietly(output);
        }
        return null;
    }
}