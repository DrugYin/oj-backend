package com.example.oj.param.Carousel;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;

/**
 * @author LiChongWei
 * @description
 * @createDate 2024/10/10 下午1:49
 */
@Data
public class AddCarouselParam {

    @NotEmpty
    private MultipartFile file;

    private String title;
}
