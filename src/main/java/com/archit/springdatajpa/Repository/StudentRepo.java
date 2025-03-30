package com.archit.springdatajpa.Repository;

import com.archit.springdatajpa.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

    //In below query ?1 represents that we will use 1st parameter passed in this method for this query.
    @Query("select s from Student s where s.name=?1")
    List<Student> findByName(String name);
}
