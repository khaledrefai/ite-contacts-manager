package com.ite.contacts.entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * not an ignored comment
 */
@Entity
@Table(name = "department")
public class Department implements Serializable {

    private static final long serialVersionUID = 1L;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @OneToMany(mappedBy = "department")
    private Set<Contact> contacts = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties("departments")
    private Branch branch;



    public Integer getDepartmentId() {
        return departmentId;
    }

    public Department departmentId(Integer departmentId) {
        this.departmentId = departmentId;
        return this;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Department departmentName(String departmentName) {
        this.departmentName = departmentName;
        return this;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public Department contacts(Set<Contact> contacts) {
        this.contacts = contacts;
        return this;
    }

    public Department addContact(Contact contact) {
        this.contacts.add(contact);
        contact.setDepartment(this);
        return this;
    }

    public Department removeContact(Contact contact) {
        this.contacts.remove(contact);
        contact.setDepartment(null);
        return this;
    }

    public void setContacts(Set<Contact> contacts) {
        this.contacts = contacts;
    }

    public Branch getBranch() {
        return branch;
    }

    public Department branch(Branch branch) {
        this.branch = branch;
        return this;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

}
