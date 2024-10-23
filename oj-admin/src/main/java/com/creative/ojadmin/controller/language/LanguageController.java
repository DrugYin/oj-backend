package com.creative.ojadmin.controller.language;

import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.language.param.CreateLanguageParam;
import com.creative.ojadmin.controller.language.param.DeleteLanguageParam;
import com.creative.ojadmin.controller.language.param.UpdateLanguageParam;
import com.creative.ojadmin.service.language.SysLanguageService;
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

    @PostMapping("/create")
    public ResponseResult<?> createLanguage(@RequestBody CreateLanguageParam param) {
        sysLanguageService.createLanguage(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/update")
    public ResponseResult<?> updateLanguage(@RequestBody UpdateLanguageParam param) {
        sysLanguageService.updateLanguage(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/delete")
    public ResponseResult<?> deleteLanguage(@RequestBody DeleteLanguageParam param) {
        sysLanguageService.deleteLanguage(param);
        return ResponseResult.success("OK");
    }

}
