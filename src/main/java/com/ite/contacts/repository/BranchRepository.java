package com.ite.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.contacts.entity.Branch;

public interface BranchRepository  extends JpaRepository<Branch, Long> {

}
