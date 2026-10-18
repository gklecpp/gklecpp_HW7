package macronutrients;

import static macronutrients.Customer.DietPlan.*;

public class Main {

    public static void main(String[] args){

        Customer[] customers = {

                new Customer("Grace", NO_RESTRICTION),
                new Customer("Kaila", PALEO),
                new Customer("Gio", VEGAN),
                new Customer("Marcus", NUT_ALLERGY),
                new Customer("Ty", NO_RESTRICTION),
                new Customer("Mickey", VEGAN)
        };

        MacronutrientFactory factory = MacronutrientFactory.getInstance();

        for (Customer customer : customers){
            String carbs = factory.createCarbs(customer.getDietPlan());

            String protein = factory.createProtein(customer.getDietPlan());

            String fats = factory.createFats(customer.getDietPlan());

            Meal meal = new Meal(carbs, protein, fats);

            System.out.println("Customer: " + customer.getName());

            System.out.println("Diet Plan: " + customer.getDietPlan());

            meal.displayMeal();
        }

    }
}
