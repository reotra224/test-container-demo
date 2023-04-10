package com.reotra.demo.testcontainerdemo;

import com.reotra.demo.testcontainerdemo.config.MySQLContainerConfig;
import com.reotra.demo.testcontainerdemo.entities.Employee;
import com.reotra.demo.testcontainerdemo.repositories.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@ExtendWith(MySQLContainerConfig.class)
@DirtiesContext
class TestContainerWithExtendTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void when_using_a_clean_db_this_should_be_empty() {
        List<Employee> employees = employeeRepository.findAll();
        assertThat(employees).hasSize(2);
    }

}
