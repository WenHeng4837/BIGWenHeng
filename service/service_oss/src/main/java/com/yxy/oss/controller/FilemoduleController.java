package com.yxy.oss.controller;

import com.yxy.oss.service.FilemoduleService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("阿里云文件管理")
@CrossOrigin //跨域
@RestController
@RequestMapping("/service_oss/service-file")
public class FilemoduleController {
   @Autowired
   FilemoduleService FileService;
        /**
         * 文件上传
         */

}
