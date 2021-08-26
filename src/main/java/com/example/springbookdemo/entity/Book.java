package com.example.springbookdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

   @Column(name = "Book_Name")
    private String bookName;

   @Column(name = "Author_Name")
    private String authorName;

   @Column(name = "Book_Price")
    private Float price;

   @Column(name = "Book_Description")
   private String desc;

    @CreationTimestamp
    private LocalDateTime createdTimeStamp;
}
