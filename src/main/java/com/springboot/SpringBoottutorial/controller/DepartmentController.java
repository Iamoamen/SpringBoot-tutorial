package com.springboot.SpringBoottutorial.controller;

import com.springboot.SpringBoottutorial.entity.Department;
import com.springboot.SpringBoottutorial.error.DepartmentNotFoundException;
import com.springboot.SpringBoottutorial.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
@Autowired
    private DepartmentService departmentService;
    private final Logger Logger = LoggerFactory.getLogger(DepartmentController.class) ;
@PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
    Logger.info("Inside saveDepartment of DepartmentController");
    return departmentService.saveDepartment(department);

    }
    @GetMapping("/departments")
    public List<Department> fetchDepartmentList(){
        Logger.info("Inside fetchDepartmentList of DepartmentController");
    return departmentService.fetchDepartmentList() ;
    }
    @GetMapping("/departments/{id}")
    public Department fetchDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {

    return departmentService.fetchDepartmentById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
    departmentService.deleteDepartmentById(departmentId);
    return "Department Deleted Successfully !!";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id")Long departmentId,
                                       @RequestBody Department department){

    return departmentService.updateDepartment(departmentId,department) ;
    }
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
    return departmentService.fetchDepartmentByName(departmentName) ;

    }

}
