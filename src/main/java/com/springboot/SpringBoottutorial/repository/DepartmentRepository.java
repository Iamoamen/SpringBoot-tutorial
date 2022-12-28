package com.springboot.SpringBoottutorial.repository;

import com.springboot.SpringBoottutorial.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Long> {

    public Department findByDepartmentName(String departmentName) ;
    public Department findByDepartmentNameIgnoreCase(String departmentName) ;
}
