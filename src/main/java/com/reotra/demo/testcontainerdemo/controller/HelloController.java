package com.reotra.demo.testcontainerdemo.controller;

import com.reotra.demo.testcontainerdemo.entities.Employee;
import com.reotra.demo.testcontainerdemo.repositories.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/hello")
public class HelloController {

    private final EmployeeRepository repository;

    public HelloController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello sory :)");
    }

    @GetMapping("/employees")
    List<Employee> all() {
        return repository.findAll();
    }
}
