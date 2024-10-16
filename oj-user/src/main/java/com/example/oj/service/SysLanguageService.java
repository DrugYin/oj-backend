package com.example.oj.service;

import com.example.oj.domain.SysLanguage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.param.languege.CreateLanguageParam;
import com.example.oj.param.languege.DeleteLanguageParam;
import com.example.oj.param.languege.UpdateLanguageParam;
import com.example.oj.vo.language.LanguagesVO;

/**
 * @author Barbuda
 * @description 针对表【sys_language】的数据库操作Service
 * @createDate 2024-10-10 19:24:55
 */
public interface SysLanguageService extends IService<SysLanguage> {

    void createLanguage(CreateLanguageParam param);

    void deleteLanguage(DeleteLanguageParam param);

    void updateLanguage(UpdateLanguageParam param);

    LanguagesVO getLanguages();

}
