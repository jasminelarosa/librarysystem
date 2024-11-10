package com.larosa.librarysystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Logbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   private String name;

   private String emailAddress;

   private String yearSection;

   private String studentID;

   private String dateTime;


}

