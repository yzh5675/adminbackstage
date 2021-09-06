package com.cs.adminbackstage.config;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;

@Data
@Component
@ConfigurationProperties(prefix = "qiniu")
public class QiNiuYunConfig {

    private String accessKey;

    private String secretKey;

    private String bucket;

    private String path;

    public String uploadImgToQiNiu(FileInputStream fs, String fileName){

        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传
//        String accessKey = "eJ6XrRb8cB-vxVPDDrr4llzRKRtfFBPZ947juAYx";
//        String secretKey = "PHaVW5x2ONZVWauTJMNZCUiZnQ-2csz6ue-hRy7k";
//        String bucket = "images4";
          //如果是Windows情况下，格式是 D:\\qiniu\\test.png
//        String localFilePath = "F:\\其他\\tupian\\tp05.jpg";
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        //String key = null;

        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);

        try {
            Response response = uploadManager.put(fs, null, upToken, null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
            String returnPath = getPath() + "/" + putRet.key;
            return returnPath;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return "";
    }
}
