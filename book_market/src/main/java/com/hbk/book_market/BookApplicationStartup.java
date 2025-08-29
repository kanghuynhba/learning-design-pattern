package com.hbk.book_market;

import com.hbk.book_market.entity.Author;
import com.hbk.book_market.entity.Category;
import com.hbk.book_market.entity.Book;

import com.hbk.book_market.builder.AuthorBuilder;
import com.hbk.book_market.builder.CategoryBuilder;
import com.hbk.book_market.builder.BookBuilder;

import com.hbk.book_market.factory.EntityFactory;

import com.hbk.book_market.repository.DatabaseContext;
import com.hbk.book_market.repository.AuthorRepository;
import com.hbk.book_market.repository.CategoryRepository;
import com.hbk.book_market.repository.BookRepository;


public class BookApplicationStartup {
    public static void main(String[] args) throws Exception {
        final BookApplication application=BookApplication.getInstance();

        final DatabaseContext databaseContext=application.getDatabaseContext();
        final EntityFactory entityFactory=application.getEntityFactory();

        final AuthorRepository authorRepository=databaseContext.newRepository(Author.class);
        final CategoryRepository categoryRepository=databaseContext.newRepository(Category.class);
        final BookRepository bookRepository=databaseContext.newRepository(Book.class);
        
        final Author author=entityFactory
            .newEntityBuilder(AuthorBuilder.class)
            .name("Dzung")
            .build();
        authorRepository.save(author);

        final Category category=entityFactory
            .newEntityBuilder(CategoryBuilder.class)
            .name("Technology")
            .build();        
        categoryRepository.save(category);

        final Book book=entityFactory
            .newEntityBuilder(BookBuilder.class)
            .name("Design Pattern")
            .authorId(author.getId())
            .categoryId(category.getId())
            .build();
        bookRepository.save(book);
    }
}
