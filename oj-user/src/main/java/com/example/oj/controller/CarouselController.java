package com.example.oj.controller;

import com.example.oj.common.model.Result;
import com.example.oj.service.SysCarouselService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

// 为这个类的接口加上地址前缀 /carousel
@RequestMapping("/carousel")
// 告诉SpringBoot这是一个控制器， 接口类
@RestController
@RequiredArgsConstructor
public class CarouselController {

    private final SysCarouselService sysCarouselService;

    @GetMapping
    public Result<?> getCarousel() {
        return Result.success(sysCarouselService.getCarousels());
    }


}
