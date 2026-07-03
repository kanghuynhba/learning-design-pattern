package com.hbk.book_market.model;

import java.util.List;

import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class AuthorModel {
    private long id;
    private String name;
    private String code;
    private String level;
    private List<BookModel> books;
}
