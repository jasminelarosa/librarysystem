package com.larosa.librarysystem.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class LogBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   private String name;

   private String yearSection;

   private String emailAddress;

   private String userId;

   private String Date;


}

