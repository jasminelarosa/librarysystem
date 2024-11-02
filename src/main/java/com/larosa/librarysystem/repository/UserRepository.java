package com.larosa.librarysystem.repository;

import com.larosa.librarysystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM user WHERE student_id = :studentId LIMIT 1", nativeQuery = true)
    public User findByStudentId(String studentId);

    @Query(value = "SELECT * FROM user", nativeQuery = true)
    public List<User> getAllUsers();
}
