package pizza;

import static pizza.Pizza.Size.*;
import static pizza.Pizza.Topping.*;

public class Main {
    public static void main(String[] args){
        System.out.println("PART 1: PIZZA HUT");
        System.out.println();

        Pizza pizza1 = new Pizza.Builder("Pizza Hut", SMALL)
                .addTopping(PEPPERONI)
                .addTopping(SAUSAGE)
                .addTopping(MUSHROOMS)
                .build();

        Pizza pizza2 = new Pizza.Builder("Pizza Hut", MEDIUM)
                .addTopping(PEPPERONI)
                .addTopping(BACON)
                .addTopping(ONIONS)
                .addTopping(OLIVES)
                .addTopping(PEPPERS)
                .addTopping(EXTRA_CHEESE)
                .build();

        Pizza pizza3 = new Pizza.Builder("Pizza Hut", LARGE)
                .addTopping(PEPPERONI)
                .addTopping(SAUSAGE)
                .addTopping(CHICKEN)
                .addTopping(BACON)
                .addTopping(MUSHROOMS)
                .addTopping(ONIONS)
                .addTopping(OLIVES)
                .addTopping(SPINACH)
                .addTopping(EXTRA_CHEESE)
                .build();

        pizza1.eat();
        pizza2.eat();
        pizza3.eat();

        System.out.println("PART 2: THREE PIZZA CHAINS");
        System.out.println();

        Pizza pizza4 = new Pizza.Builder("Pizza Hut", LARGE)
                .addTopping(PEPPERONI)
                .addTopping(BACON)
                .addTopping(CHICKEN)
                .build();

        Pizza pizza5 = new Pizza.Builder("Pizza Hut", SMALL)
                .addTopping(SAUSAGE)
                .addTopping(EXTRA_CHEESE)
                .build();

        Pizza pizza6 = new Pizza.Builder("Little Caesars", MEDIUM)
                .addTopping(PEPPERONI)
                .addTopping(SAUSAGE)
                .addTopping(MUSHROOMS)
                .addTopping(BACON)
                .addTopping(ONIONS)
                .addTopping(PEPPERS)
                .addTopping(OLIVES)
                .addTopping(EXTRA_CHEESE)
                .build();

        Pizza pizza7 = new Pizza.Builder("Little Caesars", SMALL)
                .addTopping(CHICKEN)
                .addTopping(SPINACH)
                .addTopping(PESTO)
                .addTopping(ONIONS)
                .addTopping(MUSHROOMS)
                .addTopping(EXTRA_CHEESE)
                .build();

        Pizza pizza8 = new Pizza.Builder("Dominos", SMALL)
                .addTopping(PEPPERONI)
                .build();

        Pizza pizza9 = new Pizza.Builder("Dominos", LARGE)
                .addTopping(HAM)
                .addTopping(HAM_AND_PINEAPPLE)
                .addTopping(BACON)
                .build();

        pizza4.eat();
        pizza5.eat();
        pizza6.eat();
        pizza7.eat();
        pizza8.eat();
        pizza9.eat();
    }
}
