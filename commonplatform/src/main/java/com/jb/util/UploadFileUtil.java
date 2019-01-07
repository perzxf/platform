package com.jb.util;

import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class UploadFileUtil {
    //定义上传存储路劲
    public static final String UPLOADFOLDER = "d:/uploadFiles/";

    //文件上传
    public static Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        //获取本地存储路径
        String realPath = UPLOADFOLDER;
        //获取文件名
        String fileName = file.getOriginalFilename();
        //截取文件名的后缀名
        String fileType = fileName.substring(fileName.lastIndexOf("."));
        //新的文件名
        String name = UUID.randomUUID().toString().replace("-", "") + fileType;
        File file2 = new File(realPath, name);
        //获得新的文件路径
        String filePath = realPath + name;
        System.out.println(filePath);
        File tempFile = null;
        try {
            tempFile = new File(filePath);
            FileUtils.copyInputStreamToFile(file.getInputStream(), tempFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        filePath.replace("/", "\\\\");
        Map<String, Object> fileMap = new HashMap<>();
        fileMap.put("img", filePath);
        fileMap.put("name", name);
        return fileMap;
    }


    //文件下载
    public static String downloadFile(String fileName, HttpServletResponse response) {
        ResponseEntity<byte[]> entity = null;
        //获取原文件地址
        String sourceUrl = UPLOADFOLDER + fileName;
        System.out.println(sourceUrl);
        if (sourceUrl != null) {
            //获取源文件
            File file = new File(sourceUrl);
            //文件下载
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition",
                        "attachment;fileName=" + fileName);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
