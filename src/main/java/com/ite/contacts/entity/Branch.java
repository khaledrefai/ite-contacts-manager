package com.ite.contacts.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Branch.
 */
@Entity
@Table(name = "branch")
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;

 
    
  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "branch_id")
    private Integer branchId;

    @Column(name = "branch_name")
    private String branchName;

    /**
     * A relationship
     */
    @OneToMany(mappedBy = "branch")
    private Set<Department> departments = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("branches")
    private Company company;



 

    public Integer getBranchId() {
        return branchId;
    }

    public Branch branchId(Integer branchId) {
        this.branchId = branchId;
        return this;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public Branch branchName(String branchName) {
        this.branchName = branchName;
        return this;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public Branch departments(Set<Department> departments) {
        this.departments = departments;
        return this;
    }

    public Branch addDepartment(Department department) {
        this.departments.add(department);
        department.setBranch(this);
        return this;
    }

    public Branch removeDepartment(Department department) {
        this.departments.remove(department);
        department.setBranch(null);
        return this;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Company getCompany() {
        return company;
    }

    public Branch company(Company company) {
        this.company = company;
        return this;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


}
