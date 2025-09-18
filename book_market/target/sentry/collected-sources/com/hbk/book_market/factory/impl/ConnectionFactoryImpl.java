package com.hbk.book_market.factory.impl;

import com.hbk.book_market.factory.ConnectionFactory;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactoryImpl implements ConnectionFactory {
   @Override
   public Connection newConnection() throws Exception {
       
        Dotenv dotenv=Dotenv.load(); 
        
        String port=dotenv.get("SQL_DATABASE_PORT");
        String host=dotenv.get("SQL_DATABASE_HOST");
        String name=dotenv.get("SQL_DATABASE_NAME");
        String user=dotenv.get("SQL_DATABASE_USER");
        String password=dotenv.get("SQL_DATABASE_PASSWORD");

        String url=String
            .format("jdbc:mysql://%s:%s/%s", host, port, name);

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(
           "jdbc:mysql://localhost:3306/book_market",
            user,
            password 
        );
   }
}
