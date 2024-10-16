package com.example.oj.controller;

import com.example.oj.common.model.Result;
import com.example.oj.service.SysLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/10 下午7:51
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/languages")
public class LanguageController {

    private final SysLanguageService sysLanguageService;

    @GetMapping("")
    public Result<?> getLanguages() {
        return Result.success(sysLanguageService.getLanguages());
    }

}
