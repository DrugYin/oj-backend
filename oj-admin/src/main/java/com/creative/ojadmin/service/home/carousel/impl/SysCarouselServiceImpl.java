package com.creative.ojadmin.service.home.carousel.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.creative.ojadmin.common.exception.ServiceException;
import com.creative.ojadmin.common.exception.enums.GlobalErrorCodeEnum;
import com.creative.ojadmin.controller.home.carousel.param.DeleteCarouselParam;
import com.creative.ojadmin.controller.home.carousel.param.UpdateCarouselParam;
import com.creative.ojadmin.controller.home.carousel.param.UploadCarouselParam;
import com.creative.ojadmin.domain.SysCarouselDO;
import com.creative.ojadmin.service.home.carousel.SysCarouselService;
import com.creative.ojadmin.mapper.SysCarouselMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
* @author Barbuda
* @description 针对表【sys_carousel】的数据库操作Service实现
* @createDate 2024-10-20 18:47:31
*/
@Service
@RequiredArgsConstructor
public class SysCarouselServiceImpl extends ServiceImpl<SysCarouselMapper, SysCarouselDO>
    implements SysCarouselService{

    private final String IMAGE_PATH = "D:\\Barbuda\\Project\\oj-backend\\img\\carousel";

    private final SysCarouselMapper baseMapper;

    @Override
    public void updateCarousel(UpdateCarouselParam param) {
        MultipartFile file = param.getImage();
        if (file == null) {
            throw new ServiceException(GlobalErrorCodeEnum.FILE_EMPTY);
        }
        if (file.isEmpty()) {
            throw new ServiceException(GlobalErrorCodeEnum.FILE_EMPTY);
        }
        SysCarouselDO carouselDO = baseMapper.selectOne(new LambdaQueryWrapper<SysCarouselDO>()
                .eq(SysCarouselDO::getId, param.getId())
        );
        try {
            Date date = new Date();
            String dateForm = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String imgFormat = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String imgName = UUID.randomUUID().toString() + dateForm + imgFormat;
            file.transferTo(new File(IMAGE_PATH + "\\" + imgName));
            String oldImgUrl = carouselDO.getImgurl();
            String oldImgName = oldImgUrl.substring(oldImgUrl.lastIndexOf("/") + 1);
            // 删除旧图片
            File oldFile = new File(IMAGE_PATH + "\\" + oldImgName);
            if (oldFile.exists()) {
                oldFile.delete();
            }
            carouselDO.setTitle(param.getTitle());
            carouselDO.setImgurl("\\api/image/carousel/" + imgName);
            carouselDO.setGmtModified(LocalDateTime.now());
            updateById(carouselDO);
        } catch (Exception e) {
            throw new ServiceException(GlobalErrorCodeEnum.FILE_UPLOAD_FAIL);
        }
    }

    @Override
    public void uploadCarousel(UploadCarouselParam param) {
        MultipartFile file = param.getImage();
        if (file == null) {
            throw new ServiceException(GlobalErrorCodeEnum.FILE_EMPTY);
        }
        if (file.isEmpty()) {
            throw new ServiceException(GlobalErrorCodeEnum.FILE_EMPTY);
        }
        try {
            Date date = new Date();
            String dateForm = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String imgFormat = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
            String imgName = UUID.randomUUID().toString() + dateForm + imgFormat;
            file.transferTo(new File(IMAGE_PATH + "\\" + imgName));
            SysCarouselDO carouselDO = new SysCarouselDO();
            carouselDO.setTitle(param.getTitle());
            carouselDO.setImgurl("\\api/image/carousel/" + imgName);
            carouselDO.setGmtCreate(LocalDateTime.now());
            save(carouselDO);
        } catch (Exception e) {
            throw new ServiceException(GlobalErrorCodeEnum.FILE_UPLOAD_FAIL);
        }
    }

    @Override
    public void deleteCarousel(DeleteCarouselParam param) {
        SysCarouselDO carouselDO = baseMapper.selectById(param.getId());
        String imgUrl = carouselDO.getImgurl();
        String imgName = imgUrl.substring(imgUrl.lastIndexOf("/") + 1);
        // 删除图片
        File file = new File(IMAGE_PATH + "\\" + imgName);
        if (file.exists()) {
            file.delete();
        }
        baseMapper.deleteById(param.getId());
    }
}




