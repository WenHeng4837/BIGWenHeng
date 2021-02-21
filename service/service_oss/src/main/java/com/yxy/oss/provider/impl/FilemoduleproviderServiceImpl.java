package com.yxy.oss.provider.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.ObjectMetadata;
import com.yxy.oss.bean.vofile;
import com.yxy.oss.provider.FilemoduleproviderService;
import com.yxy.oss.util.ConstantPropertiesUtil;
import com.yxy.serviceBase.exception.ServiceException;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
//如果既需要spring注入又需要当做provider，不能同时使用这两个service注解，因为同名不能import，真要用的话spring的那个可以换成@Component。
@Service(interfaceClass = FilemoduleproviderService.class, protocol = {"osshessian"})
public class FilemoduleproviderServiceImpl  implements FilemoduleproviderService {
    String endPoint = "oss-cn-beijing.aliyuncs.co";
    String accessKeyId ="LTAI4FztaeQaYLoxJbFUcK4H" ;
    String accessKeySecret ="jubKSKQabSTcWo9ZvdmjRPXE9UaY4g";
    String bucketName ="selfavatar-file";
    @Override
    public List<String> upload(MultipartFile[] files) {
        //获取阿里云存储相关常量
       /* String endPoint = ConstantPropertiesUtil.END_POINT;
        String accessKeyId = ConstantPropertiesUtil.ACCESS_KEY_ID;
        String accessKeySecret = ConstantPropertiesUtil.ACCESS_KEY_SECRET;
        String bucketName = ConstantPropertiesUtil.BUCKET_NAME;*/
       //http://
        List<String> list =new ArrayList<>();//用来存放URL
        try {
            //判断oss实例是否存在：如果不存在则创建，如果存在则获取
            OSS ossClien = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
            if (!ossClien.doesBucketExist(bucketName)) {
                //创建bucket
                ossClien.createBucket(bucketName);
                //设置oss实例的访问权限：公共读
                ossClien.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            for(int i=0;i<=files.length-1;i++){
                //获取上传文件流
                InputStream inputStream = files[i].getInputStream();
                //构建日期路径：avatar/2019/02/26/文件名
                //不能加中文不然访问不到
                //   String filePath =vofile.getSchoolName()+vofile.getYear()+vofile.getAddscoretypeName()+vofile.getUserId();
                String filePath1= new DateTime().toString("yyyy/MM/dd");
                //文件名：uuid.扩展名
                String original = files[i].getOriginalFilename();
                String fileName = UUID.randomUUID().toString();
                String fileType = original.substring(original.lastIndexOf("."));
                String newName = fileName + fileType;
                String fileUrl = filePath1 + "/" + newName;
                /*先注意阿里云默认存储图片的请求头为 image/jpeg,此时打开图片地址就会直接下载。将请求头改为image/jpg，图片就能够打开了*/
                // meta设置请求头
                ObjectMetadata meta = new ObjectMetadata();
                meta.setContentType("image/jpg");
                //文件上传至阿里云
                ossClien.putObject(bucketName, fileUrl, inputStream,meta);
                // 关闭OSSClient。
                ossClien.shutdown();
                //获取url地址
                String uploadUrl = "http://" + bucketName + "." + endPoint + "/" + fileUrl;
                list.add(uploadUrl);
            }
        } catch (IOException e) {
            throw new ServiceException(100,"文件上传失败请重新操作！");
        }
        return list;
    }

    @Override
    public void deleteFile(List<String> urls) {
// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endPoint, accessKeyId, accessKeySecret);
// 删除文件。如需删除文件夹，请将ObjectName设置为对应的文件夹名称。如果文件夹非空，则需要将文件夹下的所有object删除后才能删除该文件夹。
       try {
           for (int i = 0; i < urls.size(); i++) {
               ossClient.deleteObject(bucketName, urls.get(i));
           }
       }
       catch (Exception e){
           throw new ServiceException(100,"文件删除失败请重新操作！");
       }
// 关闭OSSClient。
        ossClient.shutdown();
    }
}
