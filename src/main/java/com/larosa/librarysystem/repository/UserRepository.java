package com.larosa.librarysystem.repository;

import com.larosa.librarysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE student_emp_id = :studentEmpId LIMIT 1", nativeQuery = true)
    public User findByStudentEmpId(String studentEmpId);


    @Query(value = "SELECT * FROM user where student_emp_id like %:studentEmpId%", nativeQuery = true)
    public List<User> findAllByStudentEmpId(String studentEmpId);

    @Query(value = "SELECT * FROM user where status = :status", nativeQuery = true)
    public List<User> findAllByStatus(String status);

    @Query(value = "SELECT * FROM user where first_name like %:name% or last_name like %:name%", nativeQuery = true)
    public List<User> findAllByFirstName(String name);
}
