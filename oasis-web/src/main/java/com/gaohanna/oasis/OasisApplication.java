package com.gaohanna.oasis;

import com.google.common.base.Predicate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * something
 *
 * @author keben
 * @date 2017/12/12
 */

@EnableSwagger2
@Configuration
@SpringBootApplication
public class OasisApplication {

    @Bean
    public Docket getDocket(){

        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (!declaringClass.isAnnotationPresent(RestController.class)){
                    return false;
                }
                return true;
            }
        };
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build();
        return docket;
    }

    private ApiInfo getApiInfo(){
        //ApiInfo apiInfo = new ApiInfo("基础框架", "这是一个项目的基础框架结构，构建新项目可以在这个基础上搭建","1.0","apiDocs","keben@maihaoche.com","","");
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("接口文档")
                .description("oasis项目接口文档")
                .version("1.0")
                .contact(new Contact("Gloria", "https://swagger.io/", "pyuyun@foxmail.com"))
                .build();
        return apiInfo;
    }


    public static void main(String[] args) {
        SpringApplication.run(OasisApplication.class, args);
    }
}
