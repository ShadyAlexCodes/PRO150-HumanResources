package pro150.ers.employeerecordsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class EmployeeRecordSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeRecordSystemApplication.class, args);
    }
}
