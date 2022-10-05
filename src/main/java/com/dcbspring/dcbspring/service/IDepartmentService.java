package com.dcbspring.dcbspring.service;

import java.util.List;

import com.dcbspring.dcbspring.entities.DepartmentEntity;
import com.dcbspring.dcbspring.errors.DepartmentNotFoundException;

public interface IDepartmentService {
    List<DepartmentEntity> getAllDepartment();
    DepartmentEntity createDepartmentEntity(DepartmentEntity departementEntity);
    DepartmentEntity getDepartmentById(Long departmentId) throws DepartmentNotFoundException;
    DepartmentEntity getDepartmentByName(String departmentName);
    DepartmentEntity updateDepartmentById(Long departmentId,DepartmentEntity departementEntity) throws DepartmentNotFoundException;
    void deleteDepartmentById(Long departmentId);
}
