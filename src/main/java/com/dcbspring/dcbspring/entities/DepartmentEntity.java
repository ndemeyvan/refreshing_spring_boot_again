package com.dcbspring.dcbspring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity(name = "departments")
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add department name")
    @NotEmpty(message = "Please add department name")
    private String departmentName;

    private String departmentAddress;

    private String departmentCode;

    public DepartmentEntity(Long departmentId, String departmentName, String departmentAddress, String departmentCode) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
        this.departmentAddress = departmentAddress;
        this.departmentCode = departmentCode;
    }


    public DepartmentEntity() {
    }


    public Long getdepartmentId() {
        return this.departmentId;
    }

    public void setdepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getdepartmentName() {
        return this.departmentName;
    }

    public void setdepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getdepartmentAddress() {
        return this.departmentAddress;
    }

    public void setdepartmentAddress(String departmentAddress) {
        this.departmentAddress = departmentAddress;
    }

    public String getdepartmentCode() {
        return this.departmentCode;
    }

    public void setdepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    @Override
    public String toString() {
        return "{" +
                " departmentId='" + departmentId + "'" +
                ", departmentName='" + departmentName + "'" +
                ", departmentAddress='" + departmentAddress + "'" +
                ", departmentCode='" + departmentCode + "'" +
                "}";
    }

}
