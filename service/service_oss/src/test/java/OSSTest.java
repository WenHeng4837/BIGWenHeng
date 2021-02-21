import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.CannedAccessControlList;
import org.junit.Test;

public class OSSTest {
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
    String accessKeyId = "你的accessKeyId ";
    String accessKeySecret = "你的accessKeySecret";
    String bucketName = "selfavatar-file";
    @Test
    public void testCreateBucket() {
        // 创建OSSClient实例。
        OSS ossClien = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 创建存储空间。
        ossClien.createBucket(bucketName);
        // 关闭OSSClient。
        ossClien.shutdown();
    }
    @Test
    public void testExist() {
        // 创建OSSClient实例。
        OSS ossClien = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        boolean exists = ossClien.doesBucketExist(bucketName);
        System.out.println(exists);
        // 关闭OSSClient。
        ossClien.shutdown();
    }
    @Test
    public void testAccessControl() {
        // 创建OSSClient实例。
        OSS ossClien = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        // 设置存储空间的访问权限为：公共读。
        ossClien.setBucketAcl(bucketName, CannedAccessControlList.PublicReadWrite);
        // 关闭OSSClient。
        ossClien.shutdown();
    }
}