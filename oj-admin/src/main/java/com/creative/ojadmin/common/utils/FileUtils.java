package com.creative.ojadmin.common.utils;

import cn.hutool.core.codec.Base64Encoder;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/10 下午4:02
 */
public class FileUtils {
    /**
     * MultipartFile 对象保存到本地
     *
     * @param multipartFile 要保存的对象
     * @param localPath     保存路径
     * @throws IOException /
     */
    public static void saveMultipartFile(MultipartFile multipartFile, String localPath) throws IOException {
        // 获取文件名
        String fileName = multipartFile.getOriginalFilename();
        if (fileName == null || fileName.isEmpty()) {
            throw new IllegalArgumentException("文件名不能为空");
        }

        // 创建目标文件对象
        File destFile = new File(localPath);

        // 将文件内容写入目标文件
        multipartFile.transferTo(destFile);
    }

    /**
     * 将MultipartFile对象转换为File对象
     *
     * @param multipartFile MultipartFile对象
     * @return File对象
     * @throws IOException /
     */
    public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IOException {
        // 创建一个临时文件
        File file = File.createTempFile("tempFile", multipartFile.getOriginalFilename());
        file.deleteOnExit(); // 在JVM退出时删除临时文件

        // 将MultipartFile的内容写入到临时文件
        Files.write(file.toPath(), multipartFile.getBytes());

        return file;
    }


    /**
     * 将File图片文件转换为base64字符串
     *
     * @param file File对象
     * @return base64字符串
     */
    public static String imgToBase64(File file) {
        InputStream in = null;
        byte[] data = null;
        try {
            in = new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 转换为base64字符串
        Base64Encoder encoder = new Base64Encoder();
        return Base64Encoder.encode(data);
    }

    public static String getImageExtension(MultipartFile multipartFile) {
        // 获取上传的文件名
        String fileName = multipartFile.getOriginalFilename();
        if (fileName == null || fileName.isEmpty()) {
            return "";
        }

        // 找到最后一个点（.）的位置
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            return ""; // 没有找到后缀
        }

        // 提取出原本的后缀
        return fileName.substring(dotIndex);
    }
}
