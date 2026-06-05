package com.siddhant.springbootTutorialMVC.Module2.controllers;

import com.siddhant.springbootTutorialMVC.Module2.dto.EmployeeDTO;
import com.siddhant.springbootTutorialMVC.Module2.entities.EmployeeEntity;
import com.siddhant.springbootTutorialMVC.Module2.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employee") //This will act as a Base Url and all the mappings mentioned below are its child
public class EmployeeController {

//    @GetMapping("/employee")
//    public String getEmployee() {
//        return "Employee";
//    }

    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return employeeRepository.findAll();
    }

//    @PostMapping
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
//        inputEmployee.setId(100L);
//        return inputEmployee;
//    }

    @PostMapping
    public EmployeeEntity createEmployee(@RequestBody EmployeeEntity inputEmployee) {
        return employeeRepository.save(inputEmployee);
    }



    @PutMapping
    public String updateEmployee() {
        return "Employee updated";
    }
}
