package com.creative.ojadmin.controller.home.carousel.param;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author LiChongWei
 * @date 2024/10/20 19:31
 * @description
 */
@Data
public class UploadCarouselParam {

    private String title;

    private MultipartFile image;

}
