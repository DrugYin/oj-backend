package com.creative.ojadmin.controller.home.carousel;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.home.carousel.param.DeleteCarouselParam;
import com.creative.ojadmin.controller.home.carousel.param.UpdateCarouselParam;
import com.creative.ojadmin.controller.home.carousel.param.UploadCarouselParam;
import com.creative.ojadmin.service.home.carousel.SysCarouselService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LiChongWei
 * @date 2024/10/20 18:49
 * @description
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/carousel")
public class CarouselController {

    private final SysCarouselService sysCarouselService;

    @SaCheckRole("admin")
    @PostMapping(value = "/update", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseResult<?> updateCarousel(UpdateCarouselParam param) {
        sysCarouselService.updateCarousel(param);
        return ResponseResult.success("OK");
    }

    @SaCheckRole("admin")
    @PostMapping(value = "/upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseResult<?> uploadCarousel(UploadCarouselParam param) {
        sysCarouselService.uploadCarousel(param);
        return ResponseResult.success("OK");
    }

    @PostMapping("/delete")
    public ResponseResult<?> deleteCarousel(@RequestBody DeleteCarouselParam param) {
        sysCarouselService.deleteCarousel(param);
        return ResponseResult.success("OK");
    }

}
