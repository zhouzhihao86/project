package com.xplore.web.utils;

import com.xplore.web.constants.AdminConfig;
import com.xplore.web.constants.Constants;
import com.xplore.web.util.FileUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by damen on 2014/12/22.
 */
public class UploadUtil {

    private static final Integer UPLOAD_MAX_SIZE = 2 * 1024 * 1024;

    public static final String RES_PATH = "resources/img/uploads/";
    private static final String FILE_PLACEHOLDER = "myfile";

    public static Map<String, String> handleFormField(HttpServletRequest request) {
        Map<String, String> fieldsMap = new HashMap<String, String>();

        ServletFileUpload sfUpload = new ServletFileUpload(new DiskFileItemFactory());
        sfUpload.setSizeMax(UPLOAD_MAX_SIZE);

        FileItemStream fileStream = null;
        String fileName = null;
        FileItemIterator iterator = null;
        try {
            iterator = sfUpload.getItemIterator(request);

            while (iterator.hasNext()) {

                fileStream = iterator.next();

                String name = fileStream.getFieldName();
                InputStream stream = fileStream.openStream();
                if (fileStream.isFormField()) {
                    fieldsMap.put(name, Streams.asString(stream, Constants.Default_SysEncoding));
                    continue;
                }

                if (StringUtils.isEmpty(fileStream.getName())) {
                    continue;
                }
//                String extName = fileStream.getName().substring(fileStream.getName().lastIndexOf("."));
//                String filename = FileUtil.randomFilename() + extName;
                String filename = FileUtil.getPureFilename(fileStream.getName());
                String path = Constants.APP_REAL_PATH + RES_PATH + filename;

                FileUtils.copyInputStreamToFile(stream, new File(path));
                stream.close();

                String imgName = AdminConfig.get(AdminConfig.KEY_CONTEXT_PATH) + "/" + RES_PATH + filename;
                fieldsMap.put(name, imgName);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

        return fieldsMap;
    }

    public static void handleFormField(HttpServletRequest request, Object obj) {

        Map<String, String> map = handleFormField(request);
        Iterator<String> iterator = map.keySet().iterator();

        try {
            while (iterator.hasNext()) {
                String key = iterator.next();
                String value = map.get(key);

                if (map.containsKey("upload_" + key)) {
                    value = map.get("upload_" + key);
                } else if (key.contains("upload_")) {
                    key = key.substring(key.lastIndexOf("upload_") + 7);
                }

                BeanUtils.setProperty(obj, key, value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

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