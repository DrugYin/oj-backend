package com.example.oj.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.domain.SysSubmission;
import com.example.oj.domain.SysUserInfo;
import com.example.oj.mapper.SysSubmissionMapper;
import com.example.oj.mapper.SysUserInfoMapper;
import com.example.oj.param.user.CreateUserInfoParam;
import com.example.oj.param.user.UserInfoParam;
import com.example.oj.service.SysUserInfoService;
import com.example.oj.vo.user.SubmitDataVO;
import com.example.oj.vo.user.UserInfoVO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_user_info】的数据库操作Service实现
 * @createDate 2024-09-19 15:06:46
 */

@Service
public class SysUserInfoServiceImpl extends ServiceImpl<SysUserInfoMapper, SysUserInfo>
        implements SysUserInfoService {

    private final SysSubmissionMapper sysSubmissionMapper;

    public SysUserInfoServiceImpl(SysSubmissionMapper sysSubmissionMapper) {
        this.sysSubmissionMapper = sysSubmissionMapper;
    }

    @Override
    public void updateUserInfo(UserInfoParam userInfoParam) {
        long id = StpUtil.getLoginIdAsLong();
        SysUserInfo sysUserInfo = getById(id);
        sysUserInfo.setUserName(userInfoParam.getCustomName());
        sysUserInfo.setBirthday(LocalDate.parse(userInfoParam.getBirthday()));
        sysUserInfo.setEmail(userInfoParam.getEmail());
        sysUserInfo.setPhone(userInfoParam.getPhone());
        sysUserInfo.setBiography(userInfoParam.getBiography());
        sysUserInfo.setSignature(userInfoParam.getSignature());
        sysUserInfo.setGmtModified(LocalDateTime.now());
        updateById(sysUserInfo);
    }

    @Override
    public UserInfoVO getUserInfo() {
        long id = StpUtil.getLoginIdAsLong();
        SysUserInfo dbUserInfo = getById(id);
        UserInfoVO userInfoVO = new UserInfoVO();
        userInfoVO.setUserId(id);
        userInfoVO.setUsername(dbUserInfo.getUserName());
        userInfoVO.setEmail(dbUserInfo.getEmail());
        userInfoVO.setPhone(dbUserInfo.getPhone());
        userInfoVO.setBirthday(dbUserInfo.getBirthday());
        userInfoVO.setSignature(dbUserInfo.getSignature());
        userInfoVO.setBiography(dbUserInfo.getBiography());
        userInfoVO.setSubmit_problem(dbUserInfo.getSubmitProblem());
        return userInfoVO;
    }

    @Override
    public void createUserInfo(CreateUserInfoParam param) {
        SysUserInfo sysUserInfo = new SysUserInfo();
        sysUserInfo.setUserName(param.getCustomName());
        sysUserInfo.setSubmitProblem("{\"0\":\"true\"}");
        sysUserInfo.setPhone("00000000000");
        sysUserInfo.setBirthday(LocalDate.parse("2000-01-01"));
        save(sysUserInfo);
    }

    @Override
    public void submitInfoChange(long userId, String problemId, int status) {
        SysUserInfo dbUserInfo = getById(userId);
        String json = dbUserInfo.getSubmitProblem();
        HashMap<String, Integer> params = JSONUtil.toBean(json, HashMap.class);
        System.out.println(params.get(problemId));
        if (!params.containsKey(problemId)) {
            params.put(problemId, status);
        } else {
            if (params.get(problemId) == 1) {
                return;
            } else {
                params.put(problemId, 1);
            }
        }
        dbUserInfo.setSubmitProblem(JSONUtil.toJsonStr(params));
        updateById(dbUserInfo);
    }

    @Override
    public SubmitDataVO getSubmitData() {
        long userId = StpUtil.getLoginIdAsLong();
        List<Long> sysSubmissions = sysSubmissionMapper.selectList(new LambdaQueryWrapper<SysSubmission>()
                .eq(SysSubmission::getUserId, userId)
                .select(SysSubmission::getStatus)
        ).stream().map(SysSubmission::getStatus).collect(Collectors.toList());
        long accept = 0;
        long wrongAnswer = 0;
        long timeLimitExceeded = 0;
        long memoryLimitExceeded = 0;
        long compileError = 0;
        long otherError = 0;
        long total = sysSubmissions.size();
        for (Long status : sysSubmissions) {
            if (status == 100) {
                accept++;
            } else if (status == 101) {
                wrongAnswer++;
            } else if (status == 102) {
                timeLimitExceeded++;
            } else if (status == 103) {
                memoryLimitExceeded++;
            } else if (status == -1) {
                compileError++;
            } else {
                otherError++;
            }
        }
        SubmitDataVO submitDataVO = new SubmitDataVO();
        submitDataVO.setAccept(accept);
        submitDataVO.setWrongAnswer(wrongAnswer);
        submitDataVO.setTimeLimitExceeded(timeLimitExceeded);
        submitDataVO.setMemoryLimitExceeded(memoryLimitExceeded);
        submitDataVO.setCompileError(compileError);
        submitDataVO.setOtherError(otherError);
        submitDataVO.setTotal(total);
        return submitDataVO;
    }
}




