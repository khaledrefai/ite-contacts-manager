package com.ite.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.contacts.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
