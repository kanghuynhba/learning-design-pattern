package com.hbk.examples.MementoDemo.demo_1;

import java.util.ArrayDeque;
import java.util.Deque;
import lombok.AllArgsConstructor;
import lombok.Data;

public final class MediatorDemo {
  @Data
  @AllArgsConstructor
  public static class Memento {
    private String state;
  }

  @Data
  public static class Originator {
    private String state;

    public Memento createMemento() {
      return new Memento(state);
    }

    public void restore(Memento memento) {
      state = memento.getState();
    }
  }

  public static class CareTaker {
    private final Deque<Memento> stack = new ArrayDeque<>();

    public void pushMemento(Memento memento) {
      stack.addFirst(memento);
    }

    public Memento popMemento() {
      return stack.pop();
    }

    public static void main(String[] args) {
      final CareTaker careTaker = new CareTaker();
    }
  }
}
