package com.example.backend.repository;

import com.example.backend.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    List<Student> findByFirstName(String name);
    Student findFirstByFirstName(String name);
    List<Student> findByLastNameLike(String name);
    @Query(value = "select * from student where first_name = :name",nativeQuery = true)
    Student findByName(@Param("name") String name);
}
