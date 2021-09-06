package com.cs.adminbackstage;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.cs.adminbackstage.config.QiNiuYunConfig;
import com.cs.adminbackstage.entity.Movie;
import com.cs.adminbackstage.mapper.MovieMapper;
import com.cs.adminbackstage.service.MovieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

@SpringBootTest
class AdminbackstageApplicationTests {
    @Autowired
    private QiNiuYunConfig qiNiuYunConfig;

    @Test
    void test01() throws FileNotFoundException {
        FileInputStream inputStream=new FileInputStream("D:\\image\\picture\\");
        qiNiuYunConfig.uploadImgToQiNiu(inputStream, null);
    }

}
