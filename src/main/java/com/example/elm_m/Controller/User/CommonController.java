package com.example.elm_m.Controller.User;

import com.example.elm_m.Result.Result;
import com.example.elm_m.Utils.AliOssUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;
import java.util.UUID;

@RestController
@RequestMapping("/user/common")
@Tag(name = "文件上传", description = "文件上传管理")
@Slf4j
public class CommonController {

    @Autowired
    private AliOssUtil aliOssUtil;

    @PostMapping("/upload")
    @Operation(summary = "文件上传")
    public Result<String> upload(MultipartFile file) {
        log.info("文件上传：{}", file);
        try {
            // 原始文件名
            String originalFilename = file.getOriginalFilename();

            // 截取后缀
            String extension = Objects.requireNonNull(originalFilename).substring(originalFilename.lastIndexOf("."));
            String fileName = UUID.randomUUID() + extension;

            String pathName = aliOssUtil.upload(file.getBytes(), fileName);
            return Result.success(pathName);
        } catch (Exception e) {
            log.info("文件上传失败", e);
            throw new RuntimeException(e);
        }
    }

}
