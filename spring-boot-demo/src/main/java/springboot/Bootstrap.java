package springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@MapperScan(basePackages = "springboot.repository.mapper")
@RestController
@SpringBootApplication
public class Bootstrap {

    public static void main(String[] args) {
        System.setProperty("org.springframework.boot.logging.LoggingSystem", "org.springframework.boot.logging.log4j2.Log4J2LoggingSystem");

        SpringApplication application = new SpringApplication(Bootstrap.class);
        application.setWebApplicationType(WebApplicationType.NONE);
        application.run(args);

        //SpringApplication.run(Bootstrap.class, args);
    }

    @GetMapping("/")
    public String index() {
        return "ok";
    }

}
