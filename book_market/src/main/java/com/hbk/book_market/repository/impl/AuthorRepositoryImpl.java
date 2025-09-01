package com.hbk.book_market.repository.impl;

import com.hbk.book_market.BookApplication;
import com.hbk.book_market.entity.Author;
import com.hbk.book_market.factory.ConnectionFactory;
import com.hbk.book_market.repository.AuthorRepository;
import com.hbk.book_market.pool.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class AuthorRepositoryImpl implements AuthorRepository {
    private final ConnectionFactory connectionFactory=
        BookApplication.getInstance().getConnectionFactory();
    @Override
    public void save(Author author) throws Exception {
        final String query = "INSERT INTO Author (name) VALUE(?)";
        final ConnectionPool connectionPool=BookApplication
            .getInstance()
            .getConnectionPool();
        final Connection connection=connectionPool.provide();
        try {
            try (
                    PreparedStatement statement=connection.prepareStatement(
                        query,
                        Statement.RETURN_GENERATED_KEYS
                    )
            ) {
                statement.setString(1, author.getName());
                statement.executeUpdate();
                try (ResultSet generatedKeys=statement.getGeneratedKeys()) {
                    if(generatedKeys.next()) {
                        author.setId(generatedKeys.getLong(1));
                    }
                }
            }
        } finally {
            connectionPool.pushBack(connection);
        }
    }
}
