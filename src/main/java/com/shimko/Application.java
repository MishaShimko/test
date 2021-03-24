package com.shimko;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author Shimko
 * @date 23.03.2021
 * @time 20:37
 */

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.shimko.repository"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(new Class<?>[] {Application.class}, args);
    }

}
