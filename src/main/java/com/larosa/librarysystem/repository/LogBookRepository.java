package com.larosa.librarysystem.repository;

import com.larosa.librarysystem.entity.Logbook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogBookRepository extends JpaRepository<Logbook, Long> {

}
