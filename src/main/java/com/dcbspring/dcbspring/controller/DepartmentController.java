package com.dcbspring.dcbspring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcbspring.dcbspring.entities.DepartmentEntity;
import com.dcbspring.dcbspring.service.impl.DepartmentServiceImpl;

@RestController()
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    // @Valid to validate entry field send by user
    @PostMapping
    public DepartmentEntity createDepartmentEntity(@Valid @RequestBody DepartmentEntity departementEntity) {
        System.out.println("departementEntity Data : " + departementEntity.toString());

        return departmentServiceImpl.createDepartmentEntity(departementEntity);
    }

    @GetMapping
    public List<DepartmentEntity> getListOfDepartment() {
        return departmentServiceImpl.getAllDepartment();
    }

    @GetMapping("/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentServiceImpl.getDepartmentById(departmentId);
    }

    @GetMapping("name/{name}")
    public DepartmentEntity getDepartmentByName(@PathVariable("name") String departmentName) {
        return departmentServiceImpl.getDepartmentByName(departmentName);
    }

    @PutMapping("/{id}")
    public DepartmentEntity updateDepartmentById(@PathVariable("id") Long departmentId,@RequestBody DepartmentEntity departementEntity) {
        return departmentServiceImpl.updateDepartmentById(departmentId,departementEntity);
    }


    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        departmentServiceImpl.deleteDepartmentById(departmentId);
        return "Department delete successfully !!!";
    }

}
