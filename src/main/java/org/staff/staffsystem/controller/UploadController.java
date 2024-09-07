package org.staff.staffsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.staff.staffsystem.pojo.Result;
import org.staff.staffsystem.utils.AliOSSUtils;

import java.io.File;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public Result upload(MultipartFile image) throws Exception{
        log.info("文件名:{}",image.getOriginalFilename());
        String url = aliOSSUtils.upload(image);
        log.info("url:{}", url);
        return Result.success(url);
    }
}
