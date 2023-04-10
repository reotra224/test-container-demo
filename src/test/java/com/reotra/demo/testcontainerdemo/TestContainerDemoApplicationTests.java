package com.reotra.demo.testcontainerdemo;

import com.reotra.demo.testcontainerdemo.config.MySQLContainerConfig;
import com.reotra.demo.testcontainerdemo.entities.Employee;
import com.reotra.demo.testcontainerdemo.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Testcontainers
class TestContainerDemoApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Container
    public static MySQLContainerConfig container = MySQLContainerConfig.getInstance();

    @DynamicPropertySource
    public static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", container::getJdbcUrl);
    }

    @Test
    void when_using_a_clean_db_this_should_be_empty() {
        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees).hasSize(2);
    }

}
