package com.example.oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysCarousel;
import com.example.oj.mapper.SysCarouselMapper;
import com.example.oj.service.SysCarouselService;
import com.example.oj.vo.carousel.CarouselVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Barbuda
 * @description 针对表【sys_carousel】的数据库操作Service实现
 * @createDate 2024-10-10 13:52:29
 */
@RequiredArgsConstructor
@Service
public class SysCarouselServiceImpl extends ServiceImpl<SysCarouselMapper, SysCarousel>
        implements SysCarouselService {

    private final String imgSrc = "C:\\Users\\Barbuda\\IdeaProjects\\oj\\img\\";

    @Override
    public PageResult<CarouselVO> getCarousels() {
        Page<SysCarousel> page = page(
                new Page<>(1, 10),
                new LambdaQueryWrapper<SysCarousel>()
                        .orderByDesc(SysCarousel::getGmtCreate)
        );
        List<CarouselVO> collect = page.getRecords().stream().map(item -> {
            CarouselVO carouselVO = new CarouselVO();
            carouselVO.setId(item.getId());
            carouselVO.setFile(item.getImgurl());
            carouselVO.setTitle(item.getTitle());
            return carouselVO;
        }).collect(Collectors.toList());
        return new PageResult<>(page.getTotal(), collect);
    }


}




