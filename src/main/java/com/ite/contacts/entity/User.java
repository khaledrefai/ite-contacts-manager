package com.ite.contacts.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "User")
public class User  {

	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;
	 
	    @Column(nullable = false, unique = true)
	    private String username;
	 
	    private String password;
	 
	    private String rolename;
	    private boolean isActive;
	    
	    @Column(name = "department_id" ,insertable = false , updatable = false)
	    private Integer departmentId;
	    @ManyToOne(fetch = FetchType.LAZY)
	    
	    @JsonIgnoreProperties("users")
	    private Department department;
	    
	    
	    
	    
	    
		public boolean isActive() {
			return isActive;
		}
		public void setActive(boolean isActive) {
			this.isActive = isActive;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRolename() {
			return rolename;
		}
		public void setRolename(String rolename) {
			this.rolename = rolename;
		}
		public Integer getDepartmentId() {
			return departmentId;
		}
		public void setDepartmentId(Integer departmentId) {
			this.departmentId = departmentId;
		}
		public Department getDepartment() {
			return department;
		}
		public void setDepartment(Department department) {
			this.department = department;
		}
	    
	    

}
