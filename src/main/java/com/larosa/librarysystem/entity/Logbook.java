package com.larosa.librarysystem.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Logbook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

   private String name;

   private String yearSection;

   private String emailAddress;

   private String studentID;

   private String dateTime;


}

