package com.example.oj.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysCarousel;
import com.example.oj.mapper.SysCarouselMapper;
import com.example.oj.param.Carousel.AddCarouselParam;
import com.example.oj.param.Carousel.DeleteCarouselParam;
import com.example.oj.service.SysCarouselService;
import com.example.oj.vo.carousel.CarouselVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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

    @Override
    public void deleteCarouselById(DeleteCarouselParam param) {
        removeById(param.getId());
    }

    @Override
    public String addCarousel(AddCarouselParam param) {
        MultipartFile file = param.getFile();
        if (file.isEmpty()) {
            return "上传失败，图片不能为空";
        }
        try {
            Date date = new Date();
            String dateForm = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String imgFormat = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String name = UUID.randomUUID() + dateForm + imgFormat;
            file.transferTo(new File(imgSrc + name));
            SysCarousel carousel = new SysCarousel();
            carousel.setTitle(param.getTitle());
            carousel.setImgurl(imgSrc + name);
            carousel.setGmtCreate(LocalDateTime.now());
            carousel.setGmtModified(LocalDateTime.now());
            save(carousel);
        } catch (Exception e) {
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

}




