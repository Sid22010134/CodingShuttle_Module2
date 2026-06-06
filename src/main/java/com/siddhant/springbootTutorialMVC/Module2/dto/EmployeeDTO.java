package com.siddhant.springbootTutorialMVC.Module2.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.siddhant.springbootTutorialMVC.Module2.annotataions.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    @NotNull(message = "Required field in EmployeeDTO")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Role should be ADMIN or USER")
    private String email;

    @Max(value = 80, message = "Age should be between 18 and 80")
    @Min(value = 18, message = "Age should be between 18 and 80")
    private Integer age;

    //@Pattern(regexp = "^(ADMIN|USER)$", message = "Role should be ADMIN or USER")
    @EmployeeRoleValidation
    @NotBlank(message = "Role should be ADMIN or USER")
    private String role;

    @Positive(message = "Salary should be positive")
    @NotNull(message = "Required field in EmployeeDTO")
    private Integer salary;


    @PastOrPresent(message = "Date of joining should be in the past or present")
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    @AssertTrue(message = "Employee should be active")
    private boolean isActive;
}
