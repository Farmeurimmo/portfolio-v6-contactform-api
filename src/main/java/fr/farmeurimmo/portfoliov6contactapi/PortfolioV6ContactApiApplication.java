package fr.farmeurimmo.portfoliov6contactapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class PortfolioV6ContactApiApplication {

    static void main(String[] args) {
        SpringApplication.run(PortfolioV6ContactApiApplication.class, args);
    }

}
