package com.hbk.book_market.mediator;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.entity.Author;
import com.hbk.book_market.entity.Book;
import com.hbk.book_market.model.AuthorModel;
import com.hbk.book_market.model.BookModel;
import com.hbk.book_market.repository.AuthorRepository;
import com.hbk.book_market.repository.BookRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookAndAuthorMediator {
  public List<AuthorModel> getAuthors() throws Exception {
    final BookApplication bookApplication = BookApplication.getInstance();

    final AuthorRepository authorRepository =
        bookApplication.getDatabaseContext().newRepository(Author.class);
    final BookRepository bookRepository =
        bookApplication.getDatabaseContext().newRepository(Book.class);

    final List<Author> authorEntities = authorRepository.findAll();
    final List<AuthorModel> authorModels =
        authorEntities.stream()
            .map(BookAndAuthorMediator::toAuthorModel)
            .collect(Collectors.toList());
    final Map<Long, AuthorModel> authorById =
        authorModels.stream().collect(Collectors.toMap(AuthorModel::getId, id -> id));

    final List<Book> bookEntities = bookRepository.findAll();
    final List<BookModel> bookModels =
        bookEntities.stream()
            .map((entity) -> toBookModel(entity, authorById.get(entity.getAuthorId())))
            .collect(Collectors.toList());
    final Map<Long, List<BookModel>> booksByAuthorId = new HashMap<>();

    // Why using for here?
    // There is book without author
    for (BookModel book : bookModels) {
      if (book.getAuthor() == null) {
        continue;
      }
      booksByAuthorId.computeIfAbsent(book.getAuthor().getId(), k -> new ArrayList<>()).add(book);
    }

    return authorEntities.stream()
        .map(entity -> toAuthorModel(entity, booksByAuthorId.get(entity.getId())))
        .collect(Collectors.toList());
  }

  public List<BookModel> getBooks() throws Exception {
    final BookApplication bookApplication = BookApplication.getInstance();

    final BookRepository bookRepository =
        bookApplication.getDatabaseContext().newRepository(Book.class);
    final AuthorRepository authorRepository =
        bookApplication.getDatabaseContext().newRepository(Author.class);

    final List<Book> bookEntities = bookRepository.findAll();

    final List<AuthorModel> authorModels = getAuthors();
    final Map<Long, AuthorModel> authorById =
        authorModels.stream().collect(Collectors.toMap(AuthorModel::getId, it -> it));

    return bookEntities.stream()
        .map(entity -> toBookModel(entity, authorById.get(entity.getAuthorId())))
        .collect(Collectors.toList());
  }

  private static AuthorModel toAuthorModel(Author authorEntity) {
    final AuthorModel model = new AuthorModel();
    model.setId(authorEntity.getId());
    model.setName(authorEntity.getName());
    model.setCode(authorEntity.getCode());
    return model;
  }

  private static AuthorModel toAuthorModel(Author authorEntity, List<BookModel> books) {
    final AuthorModel model = toAuthorModel(authorEntity);
    model.setBooks(books);
    return model;
  }

  private static BookModel toBookModel(Book bookEntity, AuthorModel authorModel) {
    final BookModel model = new BookModel();
    model.setId(bookEntity.getId());
    model.setName(bookEntity.getName());
    model.setAuthor(authorModel);
    return model;
  }
}
