package com.hbk.book_market.command;

import com.hbk.book_market.observer.VoidNoReturnObserver;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import lombok.AllArgsConstructor;

public class IterableCommand<E> extends AbstractCommand<Iterable<E>> {
  private Class<E> entityType;

  public IterableCommand<E> entityType(Class<E> entityType) {
    this.entityType = entityType;
    return this;
  }

  @Override
  protected PreparedStatement createStatement(Connection connection) throws Exception {
    final String tableName = entityType.getSimpleName();
    final String query = "SELECT * FROM " + tableName + " ORDER BY id DESC";
    return connection.prepareStatement(query);
  }

  @Override
  protected Iterable<E> executeStatement(
      PreparedStatement statement, VoidNoReturnObserver finishObserver) throws Exception {
    final ResultSet resultSet = statement.executeQuery();
    return () -> new EntityIterator<E>(entityType, resultSet, finishObserver);
  }

  @Override
  protected boolean closeStatementAsSoonAsPossible() {
    return false;
  }

  @AllArgsConstructor
  private static class EntityIterator<E> implements Iterator<E> {
    private final Class<E> entityType;
    private final ResultSet resultSet;
    private final VoidNoReturnObserver finishObserver;

    @Override
    public boolean hasNext() {
      try {
        final boolean hasNext = resultSet.next();
        if (!hasNext) {
          finishObserver.observer();
        }
        return hasNext;
      } catch (SQLException e) {
        throw new IllegalStateException(e);
      }
    }

    @SuppressWarnings("IteratorNextCannotThrowNoSuchElementException")
    @Override
    public E next() {
      try {
        final E entity = entityType.getDeclaredConstructor().newInstance();
        final Field[] fields = entityType.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
          fields[i].setAccessible(true);
          fields[i].set(entity, resultSet.getObject(i + 1));
        }
        return entity;
      } catch (Throwable e) {
        finishObserver.observer();
        throw new IllegalStateException(e);
      }
    }
  }
}
