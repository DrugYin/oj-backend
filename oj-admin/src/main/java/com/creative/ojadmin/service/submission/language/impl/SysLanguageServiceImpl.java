package com.creative.ojadmin.service.submission.language.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.controller.submission.language.param.CreateLanguageParam;
import com.creative.ojadmin.controller.submission.language.param.DeleteLanguageParam;
import com.creative.ojadmin.controller.submission.language.param.UpdateLanguageParam;
import com.creative.ojadmin.domain.SysLanguageDO;
import com.creative.ojadmin.service.submission.language.SysLanguageService;
import com.creative.ojadmin.mapper.SysLanguageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
* @author Barbuda
* @description 针对表【sys_language】的数据库操作Service实现
* @createDate 2024-10-23 11:13:45
*/
@Service
@RequiredArgsConstructor
public class SysLanguageServiceImpl extends ServiceImpl<SysLanguageMapper, SysLanguageDO>
    implements SysLanguageService{

    private final SysLanguageMapper baseMapper;

    @Override
    public void createLanguage(CreateLanguageParam param) {
        SysLanguageDO languageDO = baseMapper.selectOne(new LambdaQueryWrapper<SysLanguageDO>()
                .eq(SysLanguageDO::getName, param.getLabel())
        );
        if (languageDO != null) {
            throw new ServiceException(GlobalErrorCodeEnum.LANGUAGE_ALREADY_EXIST);
        }
        languageDO = new SysLanguageDO();
        languageDO.setName(param.getLabel());
        languageDO.setSubmitid(param.getValue());
        languageDO.setEnable(param.isEnable() ? 1 : 0);
        languageDO.setGmtCreate(LocalDateTime.now());
        languageDO.setGmtModified(LocalDateTime.now());
        save(languageDO);
    }

    @Override
    public void updateLanguage(UpdateLanguageParam param) {
        SysLanguageDO languageDO = baseMapper.selectById(param.getId());
        if(languageDO == null){
            throw new ServiceException(GlobalErrorCodeEnum.LANGUAGE_NOT_EXIST);
        }
        languageDO.setName(param.getLabel());
        languageDO.setSubmitid(param.getValue());
        languageDO.setEnable(param.isEnable() ? 1 : 0);
        languageDO.setGmtModified(LocalDateTime.now());
        updateById(languageDO);
    }

    @Override
    public void deleteLanguage(DeleteLanguageParam param) {
        SysLanguageDO languageDO = baseMapper.selectById(param.getId());
        if(languageDO == null){
            throw new ServiceException(GlobalErrorCodeEnum.LANGUAGE_NOT_EXIST);
        }
        removeById(param.getId());
    }
}




