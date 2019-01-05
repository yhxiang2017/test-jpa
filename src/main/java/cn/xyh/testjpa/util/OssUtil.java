package cn.xyh.testjpa.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Create by xyh on 2019/1/2
 */
public class OssUtil {
    private static String endpoint = "http://oss-cn-shanghai.aliyuncs.com";
    private static String accessKeyId = "LTAIKallcEpUvHcC";
    private static String accessKeySecret = "YMowGHFOcAtNWeMtPpb8edx3XdKJPd";

    private static void uploadString() {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传字符串。
        String content = "Hello OSS";
        ossClient.putObject("xyhbucket", "test.txt", new ByteArrayInputStream(content.getBytes()));

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    private static void uploadByte() {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId,accessKeySecret);

        // 上传Byte数组。
        byte[] content = "Hello OSS".getBytes();
        ossClient.putObject("xyhbucket", "tea.txt", new ByteArrayInputStream(content));

        // 关闭OSSClient。
        ossClient.shutdown();
    }


    private static void fileUpload() throws FileNotFoundException {
        // 创建OSSClient实例。
        OSSClient ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret);

        // 上传文件流。
        InputStream inputStream = new FileInputStream("C:\\aliyun\\aliyun-oss-java-sdk-demo-mvn\\oss-demo.log");
        PutObjectResult xyhbucket = ossClient.putObject("xyhbucket", "oss-demo.log", inputStream);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    public static void main(String[] args) throws FileNotFoundException {
        fileUpload();
    }
}
