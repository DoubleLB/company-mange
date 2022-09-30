package org.example.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class CompanyApp {
    public static void main(String[] args) {
        SpringApplication.run(CompanyApp.class,args);
    }

    //可以再启动类中配置允许跨域（SpringBoot的启动类本身就是配置类）
    @Bean //为Spring配置一个名称为webMvcConfigurer的bean，这个bean是SpringMvc的配置器，在其中可以配置跨域
    public WebMvcConfigurer webMvcConfigurer(){

        //创建了WebMvcConfigurer的无名子类对象（匿名类对象）
        return new WebMvcConfigurer() {

            //该配置中的addCorsMappings专于用配置跨域
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")//允许任何地址样式的请求跨域
                        .allowedOriginPatterns("*")//请求本服务端的网页资源的任何来源主机不受跨域限制
                        .allowedHeaders("*")//跨域对任何请求头都不做限制
                        .allowedMethods("*")//允许任何请求方式（GET、POST、PUT、DELETE和OPTIONS等等）跨域
                        .allowCredentials(false);//是否允许使用session进行用户追踪
            }
        };
    }
}
