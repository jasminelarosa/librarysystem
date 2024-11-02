package com.larosa.librarysystem.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String title;

    String author;

    String bookId;

    Boolean status;

    String publicationDate;

    String category;

}

