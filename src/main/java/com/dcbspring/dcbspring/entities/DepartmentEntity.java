package com.dcbspring.dcbspring.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "departments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add department name")
    @NotEmpty(message = "Please add department name")
    @Length(min = 3)
    private String departmentName;

    @NotBlank(message = "Please add department adress")
    @NotEmpty(message = "Please add department adress")
    private String departmentAddress;

    @NotBlank(message = "Please add department code")
    @NotEmpty(message = "Please add department code")
    private String departmentCode;

    
}
