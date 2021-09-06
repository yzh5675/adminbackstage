package com.cs.adminbackstage.controll;

import com.cs.adminbackstage.config.QiNiuYunConfig;
import com.cs.adminbackstage.utils.BaseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

@Controller
public class QiNiuYunControll {

    @Autowired
    private QiNiuYunConfig qiNiuYunConfig;

    @PostMapping("/qiniu")
    @ResponseBody
    public BaseResult qiNiuYunUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {

        String filename = file.getOriginalFilename();

        FileInputStream inputStream = (FileInputStream) file.getInputStream();

        filename = UUID.randomUUID() + filename;

        String link = qiNiuYunConfig.uploadImgToQiNiu(inputStream, filename);

        return new BaseResult(0, "SUCCESS", link,null);
    }
}
