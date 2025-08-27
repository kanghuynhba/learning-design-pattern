package com.hbk.book_market;

import com.hbk.book_market.entity.Author;
import com.hbk.book_market.entity.Category;
import com.hbk.book_market.entity.Book;

import com.hbk.book_market.factory.EntityFactory;

import com.hbk.book_market.repository.DatabaseContext;
import com.hbk.book_market.repository.AuthorRepository;
import com.hbk.book_market.repository.CategoryRepository;
import com.hbk.book_market.repository.BookRepository;

public class BookApplicationStartUp {
    public static void main(String[] args) throws Exception {
        final BookApplication application=BookApplication.getInstance();

        final DatabaseContext databaseContext=application.getDatabaseContext();
        final EntityFactory entityFactory=application.getEntityFactory();

        final AuthorRepository authorRepository=databaseContext.newRepository(Author.class);
        final CategoryRepository categoryRepository=databaseContext.newRepository(Category.class);
        final BookRepository bookRepository=databaseContext.newRepository(Book.class);

        
        Author author=entityFactory.newEntity(Author.class, "Dzung");
        authorRepository.save(author);

        Category category=entityFactory.newEntity(Category.class, "Technology");        
        categoryRepository.save(category);

        Book book=entityFactory.newEntity(Book.class, "Design Pattern");
        book.setAuthorId(author.getId());
        book.setCategoryId(category.getId());
        bookRepository.save(book);
    }
}
