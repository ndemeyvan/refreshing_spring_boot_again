package com.dcbspring.dcbspring.service.impl;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dcbspring.dcbspring.entities.DepartmentEntity;
import com.dcbspring.dcbspring.errors.DepartmentNotFoundException;
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
    public DepartmentEntity getDepartmentById(Long departmentId) throws DepartmentNotFoundException  {
        // .get() Because this deparment it's
        Optional<DepartmentEntity> department = departmentRepository.findById(departmentId);
        if (!department.isPresent()) {
            throw new DepartmentNotFoundException("Department not available !!! ");
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

        if (Objects.nonNull(departementEntity.getDepartmentName())
                && !"".equalsIgnoreCase(departementEntity.getDepartmentName())) {
            dbDepartement.setDepartmentName(departementEntity.getDepartmentName());
        }

        if (Objects.nonNull(departementEntity.getDepartmentAddress())
                && !"".equalsIgnoreCase(departementEntity.getDepartmentAddress())) {
            dbDepartement.setDepartmentAddress(departementEntity.getDepartmentAddress());
        }

        if (Objects.nonNull(departementEntity.getDepartmentCode())
                && !"".equalsIgnoreCase(departementEntity.getDepartmentCode())) {
            dbDepartement.setDepartmentCode(departementEntity.getDepartmentCode());
        }

        return departmentRepository.save(dbDepartement);
    }

    @Override
    public DepartmentEntity getDepartmentByName(String departmentName) {
        return departmentRepository.findByDepartmentNameIgnoreCase(departmentName);
    }

}
