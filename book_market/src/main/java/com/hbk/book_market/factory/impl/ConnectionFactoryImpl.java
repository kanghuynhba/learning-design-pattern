package com.hbk.book_market.factory.impl;

import com.hbk.book_market.factory.ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryImpl implements ConnectionFactory {
   @Override
   public Connection newConnection() throws Exception {
       Class.forName("com.mysql.cj.jdbc.Driver");
       return DriverManager.getConnection(
           "jdbc:mysql://localhost:3306/book_market",
           "root",
           "secret"
        );
   }
}
