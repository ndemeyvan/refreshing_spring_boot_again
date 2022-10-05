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
import com.dcbspring.dcbspring.errors.DepartmentNotFoundException;
import com.dcbspring.dcbspring.service.impl.DepartmentServiceImpl;

@RestController()
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;

    private final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(DepartmentController.class);

    // @Valid to validate entry field send by user
    @PostMapping
    public DepartmentEntity createDepartmentEntity(@Valid @RequestBody DepartmentEntity departementEntity) {
        LOGGER.info("Inside createDepartmentEntity controller of DepartmentController ");
        return departmentServiceImpl.createDepartmentEntity(departementEntity);
    }

    @GetMapping
    public List<DepartmentEntity> getListOfDepartment() {
        LOGGER.info("Inside getListOfDepartment controller of DepartmentController ");

        return departmentServiceImpl.getAllDepartment();
    }

    @GetMapping("/{id}")
    public DepartmentEntity getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        LOGGER.info("Inside getDepartmentById controller of DepartmentController ");
        return departmentServiceImpl.getDepartmentById(departmentId);
    }

    @GetMapping("name/{name}")
    public DepartmentEntity getDepartmentByName(@PathVariable("name") String departmentName) {
        LOGGER.info("Inside getDepartmentByName controller of DepartmentController ");

        return departmentServiceImpl.getDepartmentByName(departmentName);
    }

    @PutMapping("/{id}")
    public DepartmentEntity updateDepartmentById(@PathVariable("id") Long departmentId,
            @RequestBody DepartmentEntity departementEntity) {
        LOGGER.info("Inside updateDepartmentById controller of DepartmentController ");

        return departmentServiceImpl.updateDepartmentById(departmentId, departementEntity);
    }

    @DeleteMapping("/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId) {
        LOGGER.info("Inside deleteDepartmentById controller of DepartmentController ");
        departmentServiceImpl.deleteDepartmentById(departmentId);
        return "Department delete successfully !!!";
    }

}
