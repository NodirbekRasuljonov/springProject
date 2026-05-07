package org.example.firstrestapiproject;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Products Api for Vistula and Nodirbek" , version = "1.0" , description = "Product Information"))
public class FirstrestapiProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstrestapiProjectApplication.class, args);
    }

}
