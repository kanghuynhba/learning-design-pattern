package BuilderDemo;

import lombok.ToString;
import lombok.Setter;
import lombok.AllArgsConstructor;

public final class Application {
    @ToString
    @AllArgsConstructor
    public static class Product {
        private String property;
    }

    public abstract static class Builder {
        @Setter
        protected String property;
        public abstract void buildPart();
        public abstract Product getResult();
    }

    @Setter
    public static class ConcreteBuilder extends Builder {
        @Override
        public void buildPart() {
            if(property==null) {
                property="Unknown";
            }
        }

        @Override
        public Product getResult() {
            return new Product(property);
        }
    }

    @AllArgsConstructor
    public static class Director {
        
    }
}
