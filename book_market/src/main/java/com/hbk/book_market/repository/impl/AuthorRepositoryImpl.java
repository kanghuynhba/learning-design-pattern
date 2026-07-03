package com.hbk.book_market.repository.impl;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.entity.Author;
import com.hbk.book_market.entity.Book;
import com.hbk.book_market.pool.ConnectionPool;
import com.hbk.book_market.repository.AuthorRepository;
import com.hbk.book_market.repository.BookRepository;
import com.hbk.book_market.strategy.AuthorLevelStrategyContext;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AuthorRepositoryImpl implements AuthorRepository {

  @Override
  public void updateAuthorLevel(long authorId) throws Exception {
    Author author = findById(authorId);
    if (author == null) {
      return;
    }
    final BookApplication bookApplication = BookApplication.getInstance();
    final BookRepository bookRepository =
        bookApplication.getDatabaseContext().newRepository(Book.class);
    final long bookCount = bookRepository.countBookByAuthorId(authorId);
    final AuthorLevelStrategyContext authorLevelStrategyContext =
        bookApplication.getStrategyProvide().getStrategy(AuthorLevelStrategyContext.class);
    final String authorLevel = authorLevelStrategyContext.decideAuthorLevel(bookCount);

    final String query = "UPDATE Author SET level = ? WHERE id = ?";
    final ConnectionPool connectionPool = bookApplication.getConnectionPool();
    try (Connection connection = connectionPool.provide();
        PreparedStatement statement = connection.prepareStatement(query)) {
      statement.setString(1, authorLevel);
      statement.setLong(2, authorId);
      statement.executeUpdate();
    }
  }
}
