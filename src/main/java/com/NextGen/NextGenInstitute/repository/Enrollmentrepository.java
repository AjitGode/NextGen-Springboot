package com.NextGen.NextGenInstitute.repository;

import com.NextGen.NextGenInstitute.Entity.Enrollment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Enrollmentrepository extends JpaRepository<Enrollment, Integer> {
}
