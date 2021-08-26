package com.example.springbookdemo.service;

import com.example.springbookdemo.bookdto.BookDto;
import com.example.springbookdemo.entity.Book;
import com.example.springbookdemo.exeption.BookExecption;
import com.example.springbookdemo.exeption.BookNotExistException;
import com.example.springbookdemo.response.Response;
import com.example.springbookdemo.respository.Bookrepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookImp implements BookService {

    Bookrepo bookrepo;
    Response response;

    @Autowired
    public BookImp(Bookrepo bookrepo) {
        this.bookrepo = bookrepo;
    }

    @Override
    public void registerBook(BookDto bookDto) {
        Optional<Book> isExistingBook = bookrepo.findByBookName(bookDto.getBookName());
        if (isExistingBook.isPresent()) {

            throw new BookExecption(HttpStatus.CONFLICT.value(),
                    "Book is already present in the system please register another book");
        }
        Book book = new Book();
        BeanUtils.copyProperties(bookDto, book);
      //  System.out.println("Successfully copy data");
        bookrepo.save(book);
        // System.out.println("Successfully save data");
    }

    @Override
    public Book getBookbyID(Long id) {
        return bookrepo.findById(id).orElseThrow(() -> new BookNotExistException());
    }

    @Override
    public void deleteBookbyId(Long id) {
        bookrepo.deleteById(id);
    }

    @Override
    public Book updateBook(Long id, BookDto bookDto) {
        return null;
    }
}
