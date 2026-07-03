package com.hbk.examples.TemplateMethodDemo.demo_1;

public final class TemplateMethodDemo {
  public abstract static class AbstractClass {
    public void TemplateMethod() {
      step1();
      step2();
      step3();
      step4();
    }

    protected void step1() {}

    protected void step2() {}

    protected void step3() {}

    protected void step4() {}
  }

  public static class ConcreteClass1 extends AbstractClass {
    @Override
    protected void step3() {
      System.out.println("Step 3");
    }

    @Override
    protected void step4() {
      System.out.println("Step 4");
    }
  }

  public static class ConcreteClass2 extends AbstractClass {
    @Override
    protected void step1() {
      System.out.println("Step 1");
    }

    @Override
    protected void step2() {
      System.out.println("Step 2");
    }

    @Override
    protected void step3() {
      System.out.println("Step 3");
    }

    @Override
    protected void step4() {
      System.out.println("Step 4");
    }
  }

  public static void main(String[] args) {
    AbstractClass obj = new ConcreteClass1();
    obj.TemplateMethod();
    obj = new ConcreteClass2();
    obj.TemplateMethod();
  }
}
