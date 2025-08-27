package com.hbk.book_market;

import com.hbk.book_market.factory.EntityFactory;
import com.hbk.book_market.factory.impl.EntityFactoryImpl;
import com.hbk.book_market.factory.ConnectionFactory;
import com.hbk.book_market.factory.impl.ConnectionFactoryImpl;
import com.hbk.book_market.repository.DatabaseContext;
import com.hbk.book_market.repository.impl.DatabaseContextImpl;

import lombok.Getter;

public final class BookApplication {
    @Getter
    private final EntityFactory entityFactory; 
    @Getter
    private final ConnectionFactory connectionFactory;
    @Getter
    private final DatabaseContext databaseContext;
    private static final BookApplication INSTANCE= null;
    private BookApplication() {
        entityFactory=new EntityFactoryImpl();
        connectionFactory=new ConnectionFactoryImpl();
        databaseContext=new DatabaseContextImpl();
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
