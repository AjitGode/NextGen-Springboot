package com.NextGen.NextGenInstitute.repository;

import com.NextGen.NextGenInstitute.Entity.ContactForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Contactrepository extends JpaRepository<ContactForm, Integer> {
}
