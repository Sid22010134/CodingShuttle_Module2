package com.siddhant.springbootTutorialMVC.Module2.controllers;

import com.siddhant.springbootTutorialMVC.Module2.dto.EmployeeDTO;
import com.siddhant.springbootTutorialMVC.Module2.entities.EmployeeEntity;
import com.siddhant.springbootTutorialMVC.Module2.services.EmployeeService;
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

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        return employeeService.getEmployeeById(id);

    }

    @GetMapping
    public List<EmployeeDTO> getAllEmployees(@RequestParam(required = false) Integer age,
                                  @RequestParam(required = false) String sortBy) {
        return employeeService.getAllEmployees();
    }

//    @PostMapping
//    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
//        inputEmployee.setId(100L);
//        return inputEmployee;
//    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }



    @PutMapping
    public String updateEmployee() {
        return "Employee updated";
    }
}
