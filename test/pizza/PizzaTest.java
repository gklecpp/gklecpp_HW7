package pizza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PizzaTest {

    @Test
    void testSmallPizza(){
        Pizza pizza = new Pizza.Builder("Pizza Hut", Pizza.Size.SMALL).addTopping(Pizza.Topping.PEPPERONI).build();

        String output = captureOutput(pizza);

        assertTrue(output.contains("Pizza Chain: Pizza Hut"));
        assertTrue(output.contains("Size: SMALL"));
        assertTrue(output.contains("PEPPERONI"));

    }

    @Test
    void testMediumPizza(){
        Pizza pizza = new Pizza.Builder("Little Caesars", Pizza.Size.MEDIUM).addTopping(Pizza.Topping.SAUSAGE).build();

        String output = captureOutput(pizza);

        assertTrue(output.contains("Pizza Chain: Little Caesars"));
        assertTrue(output.contains("Size: MEDIUM"));
        assertTrue(output.contains("SAUSAGE"));

    }

    @Test
    void testLargePizza(){
        Pizza pizza = new Pizza.Builder("Dominos", Pizza.Size.LARGE).addTopping(Pizza.Topping.BACON).build();

        String output = captureOutput(pizza);

        assertTrue(output.contains("Pizza Chain: Dominos"));
        assertTrue(output.contains("Size: LARGE"));
        assertTrue(output.contains("BACON"));

    }

    @Test
    void testMultipleToppings() {
        Pizza pizza = new Pizza.Builder("Pizza Hut", Pizza.Size.LARGE).addTopping(Pizza.Topping.PEPPERONI).addTopping(Pizza.Topping.MUSHROOMS).addTopping(Pizza.Topping.OLIVES).build();

        String output = captureOutput(pizza);

        assertTrue(output.contains("Toppings: [PEPPERONI, MUSHROOMS, OLIVES]"));
    }

    @Test
    void testMissingSize(){
        assertThrows(IllegalArgumentException.class, () -> new Pizza.Builder("Pizza Hut", null));
    }

    @Test
    void testMissingChain(){
        assertThrows(IllegalArgumentException.class, () -> new Pizza.Builder(null, Pizza.Size.SMALL));
    }

    @Test
    void testBlankChain(){
        assertThrows(IllegalArgumentException.class, () -> new Pizza.Builder(" ", Pizza.Size.MEDIUM));
    }

    @Test
    void testNullTopping(){
        Pizza.Builder builder = new Pizza.Builder("Pizza Hut", Pizza.Size.LARGE);

        assertThrows(IllegalArgumentException.class, () -> builder.addTopping(null));
    }

    private String captureOutput(Pizza pizza){
        PrintStream original = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        try {
            System.setOut(new PrintStream(output));
            pizza.eat();
        } finally {
            System.setOut(original);
        }

        return output.toString();
    }
}
