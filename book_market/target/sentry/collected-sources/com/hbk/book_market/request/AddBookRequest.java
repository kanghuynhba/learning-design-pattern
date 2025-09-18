package com.hbk.book_market.request;

import lombok.Data;

@Data
public class AddBookRequest {
    private String bookName;
    private long authorId;
    private long categoryId;
}
