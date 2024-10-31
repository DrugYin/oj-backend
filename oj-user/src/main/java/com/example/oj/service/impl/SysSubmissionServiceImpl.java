package com.example.oj.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysProblem;
import com.example.oj.domain.SysSubmission;
import com.example.oj.domain.SysUser;
import com.example.oj.domain.SysUserInfo;
import com.example.oj.mapper.*;
import com.example.oj.param.notice.QueryPageParam;
import com.example.oj.param.submission.SubmitCodeParam;
import com.example.oj.service.SysSubmissionService;
import com.example.oj.vo.submission.SubmissionVO;
import com.example.oj.vo.submission.SubmitCodeVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 25201
 * @description 针对表【sys_submission】的数据库操作Service实现
 * @createDate 2024-06-26 13:57:45
 */
@RequiredArgsConstructor
@Slf4j
@Service
public class SysSubmissionServiceImpl extends ServiceImpl<SysSubmissionMapper, SysSubmission>
        implements SysSubmissionService {

    // 沙箱接口地址
    private static final String BASE_URL = "https://judge0-ce.p.rapidapi.com/submissions/batch";
//    private static final String BASE_URL = "http://154.9.253.106:2358/submissions/batch";
//    private static final String BASE_URL = "http://judge.api.hlkjstudio.top/run";

    private final SysUserMapper sysUserMapper;
    private final SysProblemMapper sysProblemMapper;
    private final SysProblemTestMapper sysProblemTestMapper;
    private final SysUserInfoServiceImpl sysUserInfoServiceImpl;
    private final SysUserInfoMapper sysUserInfoMapper;

    @Override
    public SubmitCodeVO submitCode(SubmitCodeParam param) {
        SysSubmission sysSubmission = new SysSubmission();
        sysSubmission.setCode(param.getCode());
        sysSubmission.setProblemId(param.getProblemId());
        sysSubmission.setSubmitTime(LocalDate.now());
        sysSubmission.setGmtCreate(LocalDateTime.now());
        sysSubmission.setGmtModified(LocalDateTime.now());
        sysSubmission.setLanguageId(param.getLanguage());
        // 获取当前登录用户的id
        sysSubmission.setUserId(StpUtil.getLoginIdAsLong());
        sysSubmission.setStatus(0L);
        // 存储测评记录
        save(sysSubmission);


        // 测评，创建一个线程，并测评
        Thread thread = new Thread(() -> startJudge(sysSubmission));
        // 启动线程
        thread.start();

        SubmitCodeVO submitCodeVO = new SubmitCodeVO();
        submitCodeVO.setSubmissionId(sysSubmission.getId());
        return submitCodeVO;
    }

    @Override
    public PageResult<SubmissionVO> pageQuery(QueryPageParam param) {

        List<Long> userIds = sysUserMapper.selectList(new LambdaQueryWrapper<SysUser>()
                .like(SysUser::getUsername, "%" + param.getSearchUserValue().replace("_", "\\_").replace("%", "\\%") + "%")
                .select(SysUser::getId)).stream().map(SysUser::getId).collect(Collectors.toList());

        List<Long> userInfoIds = sysUserInfoMapper.selectList(new LambdaQueryWrapper<SysUserInfo>()
                .like(SysUserInfo::getUserName, "%" + param.getSearchUserValue().replace("_", "\\_").replace("%", "\\%") + "%")
                .select(SysUserInfo::getId)).stream().map(SysUserInfo::getId).collect(Collectors.toList());

        if (userInfoIds.isEmpty()) userInfoIds.add(0L);
        if (userIds.isEmpty()) userIds.add(0L);

        System.out.println("userIds: " + userIds);
        System.out.println("userInfoIds: " + userInfoIds);

        List<Long> problemIds = getProblemIdsBySearchValue(param);

        Page<SysSubmission> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysSubmission>()
                        .in(SysSubmission::getProblemId, problemIds)
                        .in(SysSubmission::getUserId, userInfoIds)
                        .orderByDesc(SysSubmission::getGmtCreate)
        );
        return getSubmissionVOPageResult(page);
    }

    private List<Long> getProblemIdsBySearchValue(QueryPageParam param) {
        List<Long> problemIds = sysProblemMapper.selectList(new LambdaQueryWrapper<SysProblem>()
                .like(SysProblem::getTitle, "%" + param.getSearchProblemValue().replace("%", "\\%").replace("_", "\\_") + "%")
                .or()
                .like(SysProblem::getCustomId, "%" + param.getSearchProblemValue().replace("%", "\\%").replace("_", "\\_") + "%")
                .or()
                .eq(SysProblem::getId, param.getSearchProblemValue())
                .select(SysProblem::getId)).stream().map(SysProblem::getId).collect(Collectors.toList());

        if (problemIds.isEmpty()) problemIds.add(0L);
        return problemIds;
    }

    @Override
    public PageResult<SubmissionVO> problemSubmitPageQuery(QueryPageParam param) {
        Page<SysSubmission> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysSubmission>()
                        .eq(SysSubmission::getProblemId, param.getSearchProblemValue())
                        .eq(SysSubmission::getUserId, StpUtil.getLoginIdAsLong())
                        .orderByDesc(SysSubmission::getGmtCreate)
        );
        return getSubmissionVOPageResult(page);
    }

    @Override
    public PageResult<SubmissionVO> userSubmitPageQuery(QueryPageParam param) {
        Page<SysSubmission> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysSubmission>()
                        .eq(SysSubmission::getUserId, StpUtil.getLoginIdAsLong())
                        .orderByDesc(SysSubmission::getGmtCreate)
        );
        return getSubmissionVOPageResult(page);
    }

    @Override
    public PageResult<SubmissionVO> getUserSubmitsById(QueryPageParam param) {
        List<Long> problemIds = getProblemIdsBySearchValue(param);
        Page<SysSubmission> page = page(
                new Page<>(param.getPage(), param.getPageSize()),
                new LambdaQueryWrapper<SysSubmission>()
                        .in(SysSubmission::getProblemId, problemIds)
                        .eq(SysSubmission::getUserId, param.getSearchUserId())
                        .orderByDesc(SysSubmission::getGmtCreate)
        );
        return getSubmissionVOPageResult(page);
    }

    private PageResult<SubmissionVO> getSubmissionVOPageResult(Page<SysSubmission> page) {
        List<SubmissionVO> collect = page.getRecords().stream().map(item -> {
            SubmissionVO submissionVO = new SubmissionVO();
            submissionVO.setId(item.getId());
            submissionVO.setUsername(sysUserInfoMapper.selectById(item.getUserId()).getUserName());
            submissionVO.setProblemId(item.getProblemId());
            submissionVO.setProblemTitle(sysProblemMapper.selectById(item.getProblemId()).getTitle());
            submissionVO.setCustomId(sysProblemMapper.selectById(item.getProblemId()).getCustomId());
            submissionVO.setSubmissionId(item.getId());
            submissionVO.setStatus(item.getStatus());
            submissionVO.setSubmitTime(item.getGmtCreate());
            submissionVO.setRunTime(item.getRunTime());
            submissionVO.setRunMemory(item.getRunMemory());
            submissionVO.setUserId(item.getUserId());
            submissionVO.setCode(item.getCode());
            submissionVO.setCaseNumber(item.getCaseNumber());
            submissionVO.setAcNumber(item.getAcNumber());
            submissionVO.setLanguageId(item.getLanguageId());
            return submissionVO;
        }).collect(Collectors.toList());
        return new PageResult<>(page.getTotal(), collect);
    }

    /**
     * 开始测评
     *
     * @param sysSubmission /
     */
    private void startJudge(SysSubmission sysSubmission) {
        log.info("开始测评了，测评id为：{}", sysSubmission.getId());
        HashMap<String, Object> params = new HashMap<>();
        // 得到测试数据
        JSONArray jsonArray = getTestCases(sysSubmission.getProblemId());
        JSONArray submissions = new JSONArray();
        // 遍历测试数据，逐个提交
        HashMap<String, Object> param = new HashMap<>();
        for (Object o : jsonArray) {
            JSONObject jsonObject = (JSONObject) o;
            String input = jsonObject.getStr("input");
            String output = jsonObject.getStr("output");
            long problemId = sysSubmission.getProblemId();
            long runTimeLimit = sysProblemMapper.selectById(problemId).getLimitTime();
            long memoryLimit = sysProblemMapper.selectById(problemId).getLimitMemory();
            param.put("source_code", sysSubmission.getCode());
            param.put("language_id", sysSubmission.getLanguageId());
            param.put("stdin", input);
            param.put("expected_output", output);
            param.put("memory_limit", memoryLimit * 1024);
            param.put("cpu_time_limit", runTimeLimit * 1.0 / 1000);
            submissions.add(param);
        }
        update(new LambdaUpdateWrapper<SysSubmission>()
                .eq(SysSubmission::getId, sysSubmission.getId())
                .set(SysSubmission::getCaseNumber, jsonArray.size())
        );
        params.put("submissions", submissions);
        // 记录当前这个代码的执行结果
        int result = 0;
        // 调用沙箱接口，获取测评结果
        String submitTokens = getSubmitToken(params);
        log.info("提交tokens：{}", submitTokens);
        Thread thread = new Thread(() -> getSubmitStatus(submitTokens, sysSubmission));
        thread.start();
    }

    private JSONArray getTestCases(long problemId) {
        String testCasesJson = sysProblemTestMapper.selectById(problemId).getContent();
        return JSONUtil.parseArray(testCasesJson);
    }

    private void getSubmitStatus(String submitToken, SysSubmission sysSubmission) {
        log.info("开始查询提交结果，测评id为：{}", sysSubmission.getId());
        while (true) {
            String submitResult = HttpRequest.get(BASE_URL+"?tokens=" + submitToken)
                    .header("x-rapidapi-key", "37b778cb5emsh40cf2115eb1e2a7p1e8814jsnc44a1bf2a610")
                    .header("x-rapidapi-host", "judge0-ce.p.rapidapi.com")
                    .execute().body();
//            String submitResult = HttpUtil.get(BASE_URL + "?tokens=" + submitToken);
            log.info("查询提交结果：{}", submitResult);
            JSONObject submitResultJson = new JSONObject(submitResult);
            if (submitResultJson.getStr("error") != null) {
                update(new LambdaUpdateWrapper<SysSubmission>()
                        .eq(SysSubmission::getId, sysSubmission.getId())
                        .set(SysSubmission::getStatus, -1)
                );
                log.info("编译失败，测评id为：{}", sysSubmission.getId());
                return;
            }
            int statusId = 0;
            int count = 0;
            JSONArray jsonArray = new JSONArray(submitResultJson.getStr("submissions"));
            for (Object o : jsonArray) {
                JSONObject jsonObject = (JSONObject) o;
                log.info("测评结果：{}", jsonObject);
                JSONObject status = jsonObject.getJSONObject("status");
                statusId = status.getInt("id");
                if (statusId > 3) {
                    if (statusId == 4) {
                        double runTimeDouble = (Double.parseDouble(jsonObject.getStr("time")));
                        int runTime = (int) (runTimeDouble * 1000);
                        update(new LambdaUpdateWrapper<SysSubmission>()
                                .eq(SysSubmission::getId, sysSubmission.getId())
                                .set(SysSubmission::getStatus, 101)
                                .set(SysSubmission::getRunTime, runTime)
                                .set(SysSubmission::getRunMemory, jsonObject.getInt("memory"))
                                .set(SysSubmission::getOutput, jsonObject.getStr("stdout"))
                        );
                        log.info("测评失败，测评id为：{}", sysSubmission.getId());
                    } else if (statusId == 5) {
                        double runTimeDouble = (Double.parseDouble(jsonObject.getStr("time")));
                        int runTime = (int) (runTimeDouble * 1000);
                        update(new LambdaUpdateWrapper<SysSubmission>()
                                .eq(SysSubmission::getId, sysSubmission.getId())
                                .set(SysSubmission::getStatus, 102)
                                .set(SysSubmission::getRunTime, runTime)
                                .set(SysSubmission::getRunMemory, jsonObject.getInt("memory"))
                        );
                        log.info("测评超时，测评id为：{}", sysSubmission.getId());
                    } else if (statusId == 6) {
                        update(new LambdaUpdateWrapper<SysSubmission>()
                                .eq(SysSubmission::getId, sysSubmission.getId())
                                .set(SysSubmission::getStatus, -1)
                        );
                        log.info("编译失败，测评id为：{}", sysSubmission.getId());
                    } else if (statusId <= 12) {
                        update(new LambdaUpdateWrapper<SysSubmission>()
                                .eq(SysSubmission::getId, sysSubmission.getId())
                                .set(SysSubmission::getStatus, 103)
                        );
                        log.info("运行错误，测评id为：{}", sysSubmission.getId());
                    } else {
                        update(new LambdaUpdateWrapper<SysSubmission>()
                                .eq(SysSubmission::getId, sysSubmission.getId())
                                .set(SysSubmission::getStatus, -2)
                        );
                        log.info("未知错误，测评id为：{}", sysSubmission.getId());
                    }
                    sysUserInfoServiceImpl.submitInfoChange(sysSubmission.getUserId(), sysSubmission.getProblemId().toString(), 0);
                    return;
                } else if (statusId == 3) {
                    count++;
                    update(new LambdaUpdateWrapper<SysSubmission>()
                            .eq(SysSubmission::getId, sysSubmission.getId())
                            .set(SysSubmission::getAcNumber, count)
                    );
                }
            }
            if (statusId == 3 && count == jsonArray.size()) {
                double runTimeSum = 0;
                int runMemorySum = 0;
                String output = "";
                for (Object o : jsonArray) {
                    JSONObject jsonObject = (JSONObject) o;
                    runTimeSum += Double.parseDouble(jsonObject.getStr("time"));
                    runMemorySum += Integer.parseInt(jsonObject.getStr("memory"));

                }
                update(new LambdaUpdateWrapper<SysSubmission>()
                        .eq(SysSubmission::getId, sysSubmission.getId())
                        .set(SysSubmission::getStatus, 100)
                        .set(SysSubmission::getRunTime, runTimeSum / jsonArray.size() * 1000)
                        .set(SysSubmission::getRunMemory, runMemorySum / jsonArray.size())
                        .set(SysSubmission::getOutput, output)
                );
                sysUserInfoServiceImpl.submitInfoChange(sysSubmission.getUserId(), sysSubmission.getProblemId().toString(), 1);
                log.info("测评完成，测评id为：{}", sysSubmission.getId());
                return;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String getSubmitToken(HashMap<String, Object> params) {
        log.info("提交参数：{}", params);
        String post = HttpRequest.post(BASE_URL)
                .header("x-rapidapi-key", "37b778cb5emsh40cf2115eb1e2a7p1e8814jsnc44a1bf2a610")
                .header("x-rapidapi-host", "judge0-ce.p.rapidapi.com")
                .header("Content-Type", "application/json")
                .body(JSONUtil.toJsonStr(params))
                .execute().body();
//        String post = HttpUtil.post(BASE_URL, JSONUtil.toJsonStr(params));
        log.info("提交结果：{}", post);
        JSONArray jsonArray = JSONUtil.parseArray(post);
        StringBuilder tokens = new StringBuilder();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            if (i > 0) {
                tokens.append(",");
            }
            tokens.append(jsonObject.getStr("token"));
        }
        return tokens.toString();
    }
}





