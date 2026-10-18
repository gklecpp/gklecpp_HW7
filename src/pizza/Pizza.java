package pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {

    public enum Size{
        SMALL, MEDIUM, LARGE
    }

    public enum Topping{
        PEPPERONI,
        SAUSAGE,
        MUSHROOMS,
        BACON,
        ONIONS,
        EXTRA_CHEESE,
        PEPPERS,
        CHICKEN,
        OLIVES,
        SPINACH,
        TOMATO_AND_BASIL,
        BEEF,
        HAM,
        PESTO,
        SPICY_PORK,
        HAM_AND_PINEAPPLE
    }

    private final String chain;
    private final Size size;
    private final List<Topping> toppings;

    private Pizza(Builder builder){
        this.chain = builder.chain;
        this.size = builder.size;
        this.toppings = List.copyOf(builder.toppings);
    }

    public void eat(){
        System.out.println("Pizza Chain: " + chain);
        System.out.println("Size: " + size);
        System.out.println("Toppings: " + toppings);
        System.out.println();
    }

    public static class Builder{
        private final String chain;
        private final Size size;
        private final List<Topping> toppings = new ArrayList<>();

        public Builder(String chain, Size size){
            if (chain == null || chain.isBlank()){
                throw new IllegalArgumentException("Pizza chain is required.");
            }

            if (size == null){
                throw new IllegalArgumentException("Pizza size is required.");
            }

            this.chain = chain;
            this.size = size;
        }

        public Builder addTopping(Topping topping){
            if (topping == null){
                throw new IllegalArgumentException("Topping cannot be null.");
            }
            toppings.add(topping);
            return this;
        }

        public Pizza build(){
            return new Pizza(this);
        }
    }

}
