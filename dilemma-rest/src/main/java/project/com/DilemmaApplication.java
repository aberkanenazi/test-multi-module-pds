package project.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"project.com.*"})
@EntityScan(basePackages = "project.com.*" )
public class DilemmaApplication {
    public static void main(String[] args) {
        SpringApplication.run(DilemmaApplication.class);
    }

}
