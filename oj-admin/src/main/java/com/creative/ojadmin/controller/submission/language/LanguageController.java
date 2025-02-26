package com.creative.ojadmin.controller.submission.language;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.submission.language.param.CreateLanguageParam;
import com.creative.ojadmin.controller.submission.language.param.DeleteLanguageParam;
import com.creative.ojadmin.controller.submission.language.param.UpdateLanguageParam;
import com.creative.ojadmin.service.submission.language.SysLanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author LiChongWei
 * @date 2024/10/23 11:14
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/languages")
public class LanguageController {

    private final SysLanguageService sysLanguageService;

    @SaCheckRole("admin")
    @PostMapping("/create")
    public ResponseResult<?> createLanguage(@RequestBody CreateLanguageParam param) {
        sysLanguageService.createLanguage(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/update")
    public ResponseResult<?> updateLanguage(@RequestBody UpdateLanguageParam param) {
        sysLanguageService.updateLanguage(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping("/delete")
    public ResponseResult<?> deleteLanguage(@RequestBody DeleteLanguageParam param) {
        sysLanguageService.deleteLanguage(param);
        return ResponseResult.success("OK");
    }

}
