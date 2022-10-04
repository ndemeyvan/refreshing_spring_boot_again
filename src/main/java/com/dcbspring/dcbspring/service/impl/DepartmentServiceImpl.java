package com.dcbspring.dcbspring.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.dcbspring.dcbspring.entities.DepartmentEntity;
import com.dcbspring.dcbspring.repository.IDepartmentRepository;
import com.dcbspring.dcbspring.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    IDepartmentRepository departmentRepository;

    @Override
    public List<DepartmentEntity> getAllDepartment() {
        return departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity createDepartmentEntity(DepartmentEntity departmentEntity) {
        return departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity getDepartmentById(Long departmentId) {
        // .get() Because this deparment it's
        Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
        if (department.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User with id %d not found", departmentId));
        }
        // return departmentRepository.findById(departmentId).orElse(null);
        return department.get();
    }

    @Override
    public void deleteDepartmentById(Long departmentId) {
        departmentRepository.deleteById(departmentId);
    }

    @Override
    public DepartmentEntity updateDepartmentById(Long departmentId, DepartmentEntity departementEntity) {
        // find the current departement
        DepartmentEntity dbDepartement = departmentRepository.findById(departmentId).get();

        if (Objects.nonNull(departementEntity.getdepartmentName())
                && !"".equalsIgnoreCase(departementEntity.getdepartmentName())) {
            dbDepartement.setdepartmentName(departementEntity.getdepartmentName());
        }

        if (Objects.nonNull(departementEntity.getdepartmentAddress())
                && !"".equalsIgnoreCase(departementEntity.getdepartmentAddress())) {
            dbDepartement.setdepartmentAddress(departementEntity.getdepartmentAddress());
        }

        if (Objects.nonNull(departementEntity.getdepartmentCode())
                && !"".equalsIgnoreCase(departementEntity.getdepartmentCode())) {
            dbDepartement.setdepartmentCode(departementEntity.getdepartmentCode());
        }

        return departmentRepository.save(dbDepartement);
    }

    @Override
    public DepartmentEntity getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
