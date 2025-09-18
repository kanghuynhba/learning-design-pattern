package com.hbk.book_market;

import com.hbk.book_market.factory.EntityFactory;
import com.hbk.book_market.factory.impl.EntityFactoryImpl;
import com.hbk.book_market.factory.ConnectionFactory;
import com.hbk.book_market.factory.impl.ConnectionFactoryImpl;
import com.hbk.book_market.repository.DatabaseContext;
import com.hbk.book_market.repository.impl.DatabaseContextImpl;
import com.hbk.book_market.pool.ConnectionPool;
import com.hbk.book_market.command.CommandProvider;

import lombok.Getter;

public final class BookApplication {
    @Getter
    private final EntityFactory entityFactory; 
    @Getter
    private final ConnectionFactory connectionFactory;
    @Getter
    private final DatabaseContext databaseContext;
    @Getter
    private final CommandProvider commandProvider;
    @Getter
    private final ConnectionPool connectionPool;
    private static final BookApplication INSTANCE= null;
    private BookApplication() {
        entityFactory=new EntityFactoryImpl();
        connectionFactory=new ConnectionFactoryImpl();
        databaseContext=new DatabaseContextImpl();
        connectionPool=new ConnectionPool();
        commandProvider=new CommandProvider();
    }
    public static BookApplication getInstance() {
        if(INSTANCE == null) {
            synchronized (BookApplication.class) {
                if(INSTANCE == null) {
                    return new BookApplication();
                }
            }
        }
        return INSTANCE;
    }
}
