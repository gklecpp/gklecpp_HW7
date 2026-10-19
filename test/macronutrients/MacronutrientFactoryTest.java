package macronutrients;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MacronutrientFactoryTest {
    @Test
    void testCarbsFactorySingleton(){
        CarbsFactory first = CarbsFactory.getInstance();
        CarbsFactory second = CarbsFactory.getInstance();

        assertSame(first, second);
    }

    @Test
    void testProteinFactorySingleton(){
        ProteinFactory first = ProteinFactory.getInstance();
        ProteinFactory second = ProteinFactory.getInstance();

        assertSame(first, second);
    }

    @Test
    void testFatsFactorySingleton(){
        FatsFactory first = FatsFactory.getInstance();
        FatsFactory second = FatsFactory.getInstance();

        assertSame(first, second);
    }

    @Test
    void testMacronutrientFactorySingleton(){
        MacronutrientFactory first = MacronutrientFactory.getInstance();
        MacronutrientFactory second = MacronutrientFactory.getInstance();

        assertSame(first, second);
    }

    @Test
    void testCustomerInformation(){
        Customer customer = new Customer("Grace", Customer.DietPlan.VEGAN);

        assertEquals("Grace", customer.getName());
        assertEquals(Customer.DietPlan.VEGAN, customer.getDietPlan());
    }

    @Test
    void testPaleoCarbs(){
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for(int i = 0; i < 100; i++){
            String carbs = factory.createCarbs(Customer.DietPlan.PALEO);

            assertEquals("Pistachio", carbs);
        }
    }

    @Test
    void testAllDietPlansProduceMeals(){
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for (Customer.DietPlan diet : Customer.DietPlan.values()){

            String carbs = factory.createCarbs(diet);
            String protein = factory.createProtein(diet);
            String fats = factory.createFats(diet);

            assertNotNull(carbs);
            assertNotNull(protein);
            assertNotNull(fats);

            assertFalse(carbs.isBlank());
            assertFalse(protein.isBlank());
            assertFalse(fats.isBlank());

        }
    }


    @Test
    void testNoRestrictionDiet() {
        MacronutrientFactory factory =
                MacronutrientFactory.getInstance();

        for (int i = 0; i < 100; i++) {
            assertTrue(java.util.List.of("Cheese", "Bread", "Lentils", "Pistachio").contains(factory.createCarbs(Customer.DietPlan.NO_RESTRICTION)));
            assertTrue(java.util.List.of("Fish", "Chicken", "Beef", "Tofu").contains(factory.createProtein(Customer.DietPlan.NO_RESTRICTION)));
            assertTrue(java.util.List.of("Avocado", "Sour cream", "Tuna", "Peanuts").contains(factory.createFats(Customer.DietPlan.NO_RESTRICTION)));
        }
    }

    @Test
    void testPaleoDietRestrictions() {
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for (int i = 0; i < 100; i++) {
            assertEquals("Pistachio", factory.createCarbs(Customer.DietPlan.PALEO));
            assertTrue(java.util.List.of("Fish", "Chicken", "Beef").contains(factory.createProtein(Customer.DietPlan.PALEO)));
            assertTrue(java.util.List.of("Avocado", "Tuna", "Peanuts").contains(factory.createFats(Customer.DietPlan.PALEO)));
        }
    }

    @Test
    void testVeganDietRestrictions() {
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for (int i = 0; i < 100; i++) {
            assertTrue(java.util.List.of("Bread", "Lentils", "Pistachio").contains(factory.createCarbs(Customer.DietPlan.VEGAN)));
            assertEquals("Tofu", factory.createProtein(Customer.DietPlan.VEGAN));
            assertTrue(java.util.List.of("Avocado", "Peanuts").contains(factory.createFats(Customer.DietPlan.VEGAN)));
        }
    }

    @Test
    void testNutAllergyRestrictions() {
        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for (int i = 0; i < 100; i++) {
            assertTrue(java.util.List.of("Cheese", "Bread", "Lentils").contains(factory.createCarbs(Customer.DietPlan.NUT_ALLERGY)));
            assertTrue(java.util.List.of("Fish", "Chicken", "Beef", "Tofu").contains(factory.createProtein(Customer.DietPlan.NUT_ALLERGY)));
            assertTrue(java.util.List.of("Avocado", "Sour cream", "Tuna").contains(factory.createFats(Customer.DietPlan.NUT_ALLERGY)));
        }
    }

}
