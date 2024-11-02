package com.larosa.librarysystem.repository;

import com.larosa.librarysystem.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query(value = "SELECT * FROM book WHERE book_id = :bookId LIMIT 1", nativeQuery = true)
    public  Book findByBookId(String bookId);


    @Query(value = "SELECT * FROM book", nativeQuery = true)
    public List<Book> getAllUsers();
}
