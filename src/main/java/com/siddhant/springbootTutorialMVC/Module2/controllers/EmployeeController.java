package com.siddhant.springbootTutorialMVC.Module2.controllers;

import com.siddhant.springbootTutorialMVC.Module2.dto.EmployeeDTO;
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

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return new EmployeeDTO(id, "Siddhant", "siddhant@gmail.com", 22, LocalDate.of(2024, 6, 5), true);
    }

    @GetMapping
    public String getAllEmployees(@RequestParam Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return "Hello Pal with age " + age + " and sort by " + sortBy;
    }

    @PostMapping
    public String createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return "Employee created";
    }

    @PutMapping
    public String updateEmployee() {
        return "Employee updated";
    }
}
