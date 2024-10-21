package com.creative.ojadmin.controller.carousel.param;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author LiChongWei
 * @date 2024/10/20 18:49
 * @description
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class UpdateCarouselParam extends UploadCarouselParam{

    private long id;

}
