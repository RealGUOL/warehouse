package com.realguo.web.config.swagger;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * @author RealGUO
 *
 * 配置swagger
 */

@EnableOpenApi
@Configuration
public class SwaggerConfig {

    //http://localhost:8080/swagger-ui/

    @Bean
    public Docket docket(Environment environment){
        Profiles profiles = Profiles.of("dev");
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("realguo")
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.realguo.warehouse.controller"))
                .build()
                .enable(flag);
    }

    public ApiInfo apiInfo(){

        Contact contact = new Contact("RealGUO", "", "1101036063@qq.com");
        return new ApiInfo("道具仓库关系系统",
                "该系统预计支持大数据量的道具信息管理，包括道具数据导入、检索、导出、统计、账户管理、异地备份、异地登陆等功能。该项目使用JavaScript编程语言编程，采用目前流行的B/S模式，WebStorm作为前端开发工具，后台采用Node.js驱动，拟将最终系统以托管方式上线，系统运行在web浏览器中，系统的通过网络节点部署。",
                "1.0",
                "",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }


}
