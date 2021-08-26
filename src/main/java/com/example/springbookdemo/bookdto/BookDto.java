package com.example.springbookdemo.bookdto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    @NotBlank(message = "This field can not be blank, Please enter Book name")
    private String bookName;

    @NotBlank(message = "This field can not be blank, Please enter Author name")
    private String authorName;

    private String desc;

    @NotBlank(message = "This field can not be blank, Please enter price")
    private Float price;

}
