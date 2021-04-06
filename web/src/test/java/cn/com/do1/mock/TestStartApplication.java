package cn.com.do1.mock;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@Configuration
@ComponentScan(basePackages={"cn.com.do1"})
@SpringBootApplication()
public class TestStartApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(TestStartApplication.class).web(true).run(args);
    }

}