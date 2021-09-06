package com.cs.adminbackstage;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
@MapperScan("com.cs.adminbackstage.mapper")
@SpringBootApplication
public class AdminbackstageApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminbackstageApplication.class, args);
    }

    @Bean //分页配置
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor() ;
        interceptor.addInnerInterceptor (new PaginationInnerInterceptor(DbType.MYSQL)) ;
        return interceptor;
    }

    @Bean //加载中文认证提示信息
    public ReloadableResourceBundleMessageSource messageSource () {
        ReloadableResourceBundleMessageSource messagesource =
                new ReloadableResourceBundleMessageSource() ;
        //加载org/springframework/security包下的中文提示信息配置文件
        messagesource.setBasename("classpath:org/springframework/security/messages_zh_CN");
        return messagesource;
    }
}
