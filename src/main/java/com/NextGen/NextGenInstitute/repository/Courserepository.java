package com.NextGen.NextGenInstitute.repository;

import com.NextGen.NextGenInstitute.Entity.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Courserepository  extends JpaRepository<Courses, Integer> {

}
