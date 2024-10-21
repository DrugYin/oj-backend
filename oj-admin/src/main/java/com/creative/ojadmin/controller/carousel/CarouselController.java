package com.creative.ojadmin.controller.carousel;

import com.creative.ojadmin.common.pojo.ResponseResult;
import com.creative.ojadmin.controller.carousel.param.DeleteCarouselParam;
import com.creative.ojadmin.controller.carousel.param.UpdateCarouselParam;
import com.creative.ojadmin.controller.carousel.param.UploadCarouselParam;
import com.creative.ojadmin.service.carousel.SysCarouselService;
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

    @PostMapping("/update")
    public ResponseResult<?> updateCarousel(@RequestBody UpdateCarouselParam param) {
        sysCarouselService.updateCarousel(param);
        return ResponseResult.success("OK");
    }

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
