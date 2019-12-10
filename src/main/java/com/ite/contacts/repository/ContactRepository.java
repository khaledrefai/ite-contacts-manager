package com.ite.contacts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ite.contacts.entity.Contact;
import com.ite.contacts.entity.Department;
import com.ite.contacts.entity.User;

public interface ContactRepository extends JpaRepository<Contact, Long>{
	@Query("select c from Contact c  where c.department = ?1 or ?2 = 'ADMIN' ")
	List<Contact> getContacts(Department d , String role );
}
