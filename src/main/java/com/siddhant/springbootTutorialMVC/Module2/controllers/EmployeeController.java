package com.siddhant.springbootTutorialMVC.Module2.controllers;

import com.siddhant.springbootTutorialMVC.Module2.dto.EmployeeDTO;
import com.siddhant.springbootTutorialMVC.Module2.entities.EmployeeEntity;
import com.siddhant.springbootTutorialMVC.Module2.services.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id) {
        Optional<EmployeeDTO> employeeDTO = employeeService.getEmployeeById(id);
        return employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                .orElseGet(() -> ResponseEntity.notFound().build());

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

    //Put Mapping is used to update whole Data of an Object
    @PutMapping(path = "/{employeeId}") //this Path is provided of the user of which the data needs to be updated
    public EmployeeDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long employeeId) {
        return employeeService.updateEmployeeById(employeeId, employeeDTO);
    }

    @DeleteMapping(path = "/{employeeId}") //this Path is provided of the user of which the data needs to be updated
    public void deleteEmployeebyId(@PathVariable Long employeeId) {
        employeeService.deleteEmployeeById(employeeId);
    }

    @PatchMapping(path = "/{employeeId}")
    public EmployeeDTO updateEmployeePartial(@RequestBody Map<String, Object> updateObj,
                                             @PathVariable Long employeeId) {
        return employeeService.updatePartialEmployeeById(employeeId, updateObj);
    }
}
