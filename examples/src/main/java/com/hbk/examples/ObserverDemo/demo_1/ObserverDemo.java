package com.hbk.examples.ObserverDemo.demo_1;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {
  public interface Subscriber {
    void update(String state);
  }

  public static class ConcreteSubscriber1 implements Subscriber {
    @Override
    public void update(String state) {
      System.out.println("Subscriber 1 update state: " + state);
    }
  }

  public static class ConcreteSubscriber2 implements Subscriber {
    @Override
    public void update(String state) {
      System.out.println("Subscriber 2 update state: " + state);
    }
  }

  public interface Publisher {
    void subscribe(Subscriber s);

    void unsubscribe(Subscriber s);

    void notifySubscribers();

    void setState(String state);
  }

  public static class ConcretePublisher implements Publisher {
    private String state;
    private final List<Subscriber> subscribes = new ArrayList<>();

    @Override
    public void setState(String state) {
      this.state = state;
    }

    @Override
    public void subscribe(Subscriber s) {
      subscribes.add(s);
    }

    @Override
    public void unsubscribe(Subscriber s) {
      subscribes.remove(s);
    }

    @Override
    public void notifySubscribers() {
      subscribes.forEach(
          s -> {
            s.update(state);
          });
    }
  }

  public static void main(String[] args) {
    final Publisher pub = new ConcretePublisher();
    pub.subscribe(new ConcreteSubscriber1());
    pub.subscribe(new ConcreteSubscriber1());
    pub.setState("New state");
    pub.notifySubscribers();
  }
}
