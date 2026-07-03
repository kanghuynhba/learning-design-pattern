package com.hbk.examples.StrategyDemo.demo_1;

import lombok.Setter;

public final class StrategyDemo {
  public interface Strategy {
    void execute();
  }

  public static class ConcreteStrategyA implements Strategy {
    @Override
    public void execute() {
      System.out.println("do behavior A");
    }
  }

  public static class ConcreteStrategyB implements Strategy {
    @Override
    public void execute() {
      System.out.println("do behavior B");
    }
  }

  public static class ConcreteStrategyC implements Strategy {
    @Override
    public void execute() {
      System.out.println("do behavior C");
    }
  }

  public static class Context {
    @Setter private Strategy strategy;

    public void doSomething() {
      strategy.execute();
    }
  }

  public static void main(String[] args) {
    final Context context = new Context();
    context.setStrategy(new ConcreteStrategyA());
    context.doSomething();
    context.setStrategy(new ConcreteStrategyB());
    context.doSomething();
    context.setStrategy(new ConcreteStrategyC());
    context.doSomething();
  }
}
