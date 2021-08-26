package com.example.springbookdemo.respository;

import com.example.springbookdemo.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Bookrepo extends JpaRepository<Book, Long> {
    public Optional<Book> findByBookName (String bookName);
}
