package com.larosa.librarysystem.entity;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   private String title;

    private String author;

    private String bookId;

    private Boolean status;

    private String publicationDate;

    private  String category;

}

