package com.yxy.oss.provider;

import com.yxy.oss.bean.vofile;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FilemoduleproviderService {
    /**
     * 文件上传至阿里云
     * @return
     */
    public List<String> upload(MultipartFile[] files);
    public void deleteFile(List<String> urls);
}
