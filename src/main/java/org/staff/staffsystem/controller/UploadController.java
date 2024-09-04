package org.staff.staffsystem.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.staff.staffsystem.pojo.Result;

import java.io.File;
import java.util.UUID;

@RestController
@Slf4j
public class UploadController {
    @PostMapping("/upload")
    public Result upload(String username, Integer age, @RequestParam("image") MultipartFile file) throws Exception {
        log.info(" 文件上传:{},{},{}", username, age, file);
        String filename = file.getOriginalFilename();
        int index = filename.lastIndexOf(".");
        String suffix = filename.substring(index);
        String newFileName = UUID.randomUUID().toString() + suffix;

        file.transferTo(new File("E:\\"+newFileName));
        return Result.success();
    }
}
