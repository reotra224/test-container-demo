package com.reotra.demo.testcontainerdemo;

import com.reotra.demo.testcontainerdemo.entities.Employee;
import com.reotra.demo.testcontainerdemo.repositories.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TestContainerDemoApplication {

    private static final Logger log = LoggerFactory.getLogger(TestContainerDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(TestContainerDemoApplication.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new Employee("Bilbo Baggins", "burglar")));
            log.info("Preloading " + repository.save(new Employee("Frodo Baggins", "thief")));
        };
    }
}
