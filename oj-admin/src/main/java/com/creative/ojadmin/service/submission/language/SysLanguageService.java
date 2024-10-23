package com.creative.ojadmin.service.submission.language;

import com.creative.ojadmin.controller.submission.language.param.CreateLanguageParam;
import com.creative.ojadmin.controller.submission.language.param.DeleteLanguageParam;
import com.creative.ojadmin.controller.submission.language.param.UpdateLanguageParam;
import com.creative.ojadmin.domain.SysLanguageDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_language】的数据库操作Service
* @createDate 2024-10-23 11:13:45
*/
public interface SysLanguageService extends IService<SysLanguageDO> {

    void createLanguage(CreateLanguageParam param);

    void updateLanguage(UpdateLanguageParam param);

    void deleteLanguage(DeleteLanguageParam param);

}
