package com.dcbspring.dcbspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dcbspring.dcbspring.entities.DepartmentEntity;

@Repository
public interface IDepartmentRepository extends JpaRepository<DepartmentEntity,Long>{

    // ..IgnoreCase To Be case incensitive 
    public DepartmentEntity findByDepartmentNameIgnoreCase(String departmentName);
    
}
