package com.dcbspring.dcbspring.service;

import java.util.List;

import com.dcbspring.dcbspring.entities.DepartmentEntity;

public interface IDepartmentService {
    List<DepartmentEntity> getAllDepartment();
    DepartmentEntity createDepartmentEntity(DepartmentEntity departementEntity);
    DepartmentEntity getDepartmentById(Long departmentId);
    DepartmentEntity getDepartmentByName(String departmentName);
    DepartmentEntity updateDepartmentById(Long departmentId,DepartmentEntity departementEntity);
    void deleteDepartmentById(Long departmentId);

}
