package com.example.oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.domain.SysLanguage;
import com.example.oj.mapper.SysLanguageMapper;
import com.example.oj.param.languege.CreateLanguageParam;
import com.example.oj.param.languege.DeleteLanguageParam;
import com.example.oj.param.languege.UpdateLanguageParam;
import com.example.oj.service.SysLanguageService;
import com.example.oj.vo.language.LanguageVO;
import com.example.oj.vo.language.LanguagesVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_language】的数据库操作Service实现
 * @createDate 2024-10-10 19:24:55
 */
@RequiredArgsConstructor
@Service
public class SysLanguageServiceImpl extends ServiceImpl<SysLanguageMapper, SysLanguage>
        implements SysLanguageService {

    private final SysLanguageMapper sysLanguageMapper;

    @Override
    public void createLanguage(CreateLanguageParam param) {
        SysLanguage sysLanguage = new SysLanguage();
        sysLanguage.setName(param.getName());
        sysLanguage.setSubmitid(param.getSubmitId());
        sysLanguage.setEnable(param.getEnable());
        sysLanguage.setGmtCreate(LocalDateTime.now());
        sysLanguage.setGmtModified(LocalDateTime.now());
        save(sysLanguage);
    }

    @Override
    public void deleteLanguage(DeleteLanguageParam param) {
        removeById(param.getId());
    }

    @Override
    public void updateLanguage(UpdateLanguageParam param) {
        SysLanguage sysLanguage = getById(param.getId());
        sysLanguage.setName(param.getName());
        sysLanguage.setEnable(param.getEnable());
        sysLanguage.setSubmitid(param.getSubmitId());
        sysLanguage.setGmtModified(LocalDateTime.now());
        updateById(sysLanguage);
    }

    @Override
    public LanguagesVO getLanguages() {
        List<SysLanguage> sysLanguages = sysLanguageMapper.selectList(new LambdaQueryWrapper<SysLanguage>().orderByAsc(SysLanguage::getGmtCreate));
        LanguagesVO languagesVO = new LanguagesVO();
        List<LanguageVO> collect = sysLanguages.stream().map(item -> {
            LanguageVO languageVO = new LanguageVO();
            languageVO.setId(item.getId());
            languageVO.setLabel(item.getName());
            languageVO.setValue(item.getSubmitid());
            languageVO.setEnable(item.getEnable());
            return languageVO;
        }).collect(Collectors.toList());
        languagesVO.setLanguages(collect);
        return languagesVO;
    }
}




