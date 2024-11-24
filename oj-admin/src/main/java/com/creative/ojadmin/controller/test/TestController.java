package com.creative.ojadmin.controller.test;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.ZipUtil;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.common.utils.FileUtils;
import com.creative.ojadmin.controller.test.param.TestParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;

/**
 * @author LiChongWei
 * @date 2024/11/21 13:55
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController {

    private final String localPath = "D:\\Barbuda\\Project\\oj-backend\\img\\test\\";

    @PostMapping("/upload")
    public ResponseResult<?> uploadFile(TestParam param) throws IOException {
        FileUtils.saveMultipartFile(param.getFile(), localPath);
        FileUtils.unzip(localPath + param.getFile().getOriginalFilename(), localPath + "data\\");
        FileUtil.del(localPath + param.getFile().getOriginalFilename());
        return ResponseResult.success("ok");
    }
}
