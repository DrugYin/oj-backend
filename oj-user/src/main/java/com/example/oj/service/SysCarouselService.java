package com.example.oj.service;

import com.example.oj.common.model.PageResult;
import com.example.oj.domain.SysCarousel;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.oj.vo.carousel.CarouselVO;

/**
 * @author Barbuda
 * @description 针对表【sys_carousel】的数据库操作Service
 * @createDate 2024-10-10 13:52:29
 */
public interface SysCarouselService extends IService<SysCarousel> {

    PageResult<CarouselVO> getCarousels();


}
