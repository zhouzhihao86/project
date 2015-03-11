package com.xplore.web.controller.admin.common;

import com.xplore.web.constants.Constants;
import com.xplore.web.domain.upload.FileUpload;
import com.xplore.web.util.FileUtil;
import com.xplore.web.utils.FileUploadUtil;
import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URL;

/**
 * Created by damen on 2014/12/21.
 */
@Controller("ueeditor")
@RequestMapping(value = "admin")
public class UeeditorController {


    @RequestMapping(value = "config.json", method = RequestMethod.GET)
    @ResponseBody
    public byte[] config(@RequestBody byte[] stream) {

        URL url = UeeditorController.class.getResource("/config.json");

        return FileUtil.loadFileAsByteArray(url);

    }

    @RequestMapping(value = "config.json", method = RequestMethod.POST)
    @ResponseBody
    public FileUpload fileUpload(@RequestParam(value = "action", required = false) String action, HttpServletRequest request) {

        FileUpload fileUpload = new FileUpload();

        fileUpload.url = FileUploadUtil.Upload(request);

        return fileUpload;
    }
}
