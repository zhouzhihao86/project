package com.xplore.web.utils;

import com.xplore.web.constants.Constants;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Dotar on 2015/3/10.
 */
public class FileUploadUtil {

    private static final Integer UPLOAD_MAX_SIZE = 2 * 1024 * 1024;

    public static final String UPLOAD_RELATIVE_PATH = "resources/img/uploads/";

    private static String processFilename(String filename) {

        int index = filename.lastIndexOf("\\");
        filename = filename.substring(index + 1, filename.length());

        return filename;
    }

    public static String Upload(HttpServletRequest request) {

        ServletFileUpload sfUpload = new ServletFileUpload(new DiskFileItemFactory());
        sfUpload.setSizeMax(UPLOAD_MAX_SIZE);

        FileItemIterator iterator;
        FileItemStream fileitemStream = null;
        String filename = "";
        try {
            iterator = sfUpload.getItemIterator(request);

            while (iterator.hasNext()) {
                fileitemStream = iterator.next();

                String name = fileitemStream.getFieldName();
                InputStream stream = fileitemStream.openStream();
                if (fileitemStream.isFormField()) {
                    System.out.println("Form field " + name + " with value " + Streams.asString(stream) + "detected.");
                    continue;
                }

                filename = processFilename(fileitemStream.getName());
                String path = Constants.APP_REAL_PATH + UPLOAD_RELATIVE_PATH + filename;
                FileUtils.copyInputStreamToFile(stream, new File(path));

                stream.close();
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (fileitemStream != null)
            return filename;
        else
            return "";
    }
}
