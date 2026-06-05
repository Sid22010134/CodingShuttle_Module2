package com.siddhant.springbootTutorialMVC.Module2.repositories;

import com.siddhant.springbootTutorialMVC.Module2.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//We have to pass arguments in JpaRepository
//First argument is the Entity class which we need to handle
//Second argument is the Primary Key type
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

}
