package cn.com.do1.mock;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages={"cn.com.do1"})
@MapperScan("cn.com.do1.mock.dao")
@SpringBootApplication
public class StartApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(StartApplication.class).web(true).run(args);
    }

}