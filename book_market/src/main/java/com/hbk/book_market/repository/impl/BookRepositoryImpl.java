package com.hbk.book_market.repository.impl;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.pool.ConnectionPool;
import com.hbk.book_market.repository.BookRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BookRepositoryImpl implements BookRepository {
  public long countBookByAuthorId(long authodId) throws Exception {
    final String query = "SELECT count(*) FROM Book WHERE authodId = ?";
    final ConnectionPool connectionPool = BookApplication.getInstance().getConnectionPool();
    try (Connection connection = connectionPool.provide();
        PreparedStatement statement = connection.prepareStatement(query); ) {
      statement.setLong(1, authodId);
      final ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()) {
        return resultSet.getLong(1);
      }
      return 0L;
    }
  }
}
