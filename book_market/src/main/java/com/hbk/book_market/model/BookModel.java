package com.hbk.book_market.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BookModel implements Cloneable {
  private long id;
  private String name;
  private AuthorModel author;

  // this clone is used as a deep copy Memento
  @Override
  public BookModel clone() {
    final BookModel clone = new BookModel();
    clone.id = id;
    clone.name = name;
    clone.author = author;
    return clone;
  }
}
