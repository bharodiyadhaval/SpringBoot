package com.example.springbookdemo.service;

import com.example.springbookdemo.bookdto.BookDto;
import com.example.springbookdemo.entity.Book;

public interface BookService {

    public void registerBook (BookDto bookDto);
    public Book getBookbyID(Long id);
    public void deleteBookbyId(Long id);
    public Book updateBook(Long id, BookDto bookDto);
}
