package com.mantou.mantoubo.config.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author lm
 * @title: SwaggerConfig
 * @projectName mantou-bo
 * @description: TODO
 * @date 2021/11/2116:06
 */
@Configuration
@EnableSwagger2     // 开启Swagger2 功能
public class SwaggerConfig {

    /**
     * 配置swagger的docket的bean实例
     * @return
     */
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.mantou.mantoubo.web"))
                .paths(PathSelectors.any())
                .build();
    }

    /**
     * 配置swagger的信息 apiInfo
     * @return
     */
    private ApiInfo apiInfo(){
        // 作者信息
        Contact contact = new Contact(
                "montyLee",
                "http://www.mantou.pub/",
                "limeng_email@163.com");
        return new ApiInfo(
                "馒头的SwaggerAPI文档",
                "馒头，创造世界",
                "V1.0",
                "https://blog.csdn.net/montylee",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<>());
    }

}
