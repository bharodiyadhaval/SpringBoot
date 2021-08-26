package com.example.springbookdemo.controller;

import com.example.springbookdemo.bookdto.BookDto;
import com.example.springbookdemo.entity.Book;
import com.example.springbookdemo.response.Response;
import com.example.springbookdemo.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/Book")
public class BookController {

    @Autowired
    BookService bookservice;

    @PostMapping("/registerBook")
    public ResponseEntity<Response> register(@Valid @RequestBody BookDto bookDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return new ResponseEntity<Response>(new Response(HttpStatus.UNPROCESSABLE_ENTITY.value(), bindingResult.getAllErrors().get(0).getDefaultMessage(), ""),HttpStatus.UNPROCESSABLE_ENTITY);
        }
        bookservice.registerBook(bookDto);
       return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(), "Book Register Successfully",bookDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response> getBookbyID(@PathVariable Long id)
    {
      Book bookDto =  bookservice.getBookbyID(id);
        return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(), "Book Fetched Successfully", bookDto), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Response> deleteBookbyID(@PathVariable Long id)
    {
    bookservice.deleteBookbyId(id);
        return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(), "Book Deleted Successfully",""), HttpStatus.CREATED);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<Response>updateBook(@PathVariable Long id,@Valid @RequestBody BookDto bookDto, BindingResult bindingResult)
//    {
//        if(bindingResult.hasErrors()) {
//            return new ResponseEntity<Response>(new Response(HttpStatus.UNPROCESSABLE_ENTITY.value(), bindingResult.getAllErrors().get(0).getDefaultMessage(), ""),HttpStatus.UNPROCESSABLE_ENTITY);
//        }
//       bookservice.updateBook(id,bookDto);
//        return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(), "Book Updated Successfully", bookDto), HttpStatus.CREATED);
//    }
}