package com.ite.contacts.entity;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Company.
 */
@Entity
@Table(name = "company")
public class Company implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Integer companyId;

    @Column(name = "company_name")
    private String companyName;

    @OneToMany(mappedBy = "company")
    private Set<Branch> branches = new HashSet<>();


    public Integer getCompanyId() {
        return companyId;
    }

    public Company companyId(Integer companyId) {
        this.companyId = companyId;
        return this;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Company companyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Set<Branch> getBranches() {
        return branches;
    }

    public Company branches(Set<Branch> branches) {
        this.branches = branches;
        return this;
    }

    public Company addBranch(Branch branch) {
        this.branches.add(branch);
        branch.setCompany(this);
        return this;
    }

    public Company removeBranch(Branch branch) {
        this.branches.remove(branch);
        branch.setCompany(null);
        return this;
    }

    public void setBranches(Set<Branch> branches) {
        this.branches = branches;
    }


}
