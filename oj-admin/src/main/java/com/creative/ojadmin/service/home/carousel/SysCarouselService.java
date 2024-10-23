package com.creative.ojadmin.service.home.carousel;

import com.creative.ojadmin.controller.home.carousel.param.DeleteCarouselParam;
import com.creative.ojadmin.controller.home.carousel.param.UpdateCarouselParam;
import com.creative.ojadmin.controller.home.carousel.param.UploadCarouselParam;
import com.creative.ojadmin.domain.SysCarouselDO;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author Barbuda
* @description 针对表【sys_carousel】的数据库操作Service
* @createDate 2024-10-20 18:47:31
*/
public interface SysCarouselService extends IService<SysCarouselDO> {

    void updateCarousel(UpdateCarouselParam param);

    void uploadCarousel(UploadCarouselParam param);

    void deleteCarousel(DeleteCarouselParam param);

}
