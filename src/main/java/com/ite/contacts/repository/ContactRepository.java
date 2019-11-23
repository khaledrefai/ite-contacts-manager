package com.ite.contacts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ite.contacts.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>{

}
