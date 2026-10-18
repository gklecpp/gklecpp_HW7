package macronutrients;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FatsFactory {

    private static final FatsFactory instance = new FatsFactory();
    private final Random random = new Random();

    private FatsFactory(){

    }

    public static FatsFactory getInstance() {
        return instance;
    }

    public String createFats(Customer.DietPlan dietPlan){
        List<String> options = new ArrayList<>();

        switch (dietPlan){
            case NO_RESTRICTION:
                options.add("Avocado");
                options.add("Sour cream");
                options.add("Tuna");
                options.add("Peanuts");
                break;

            case PALEO:
                options.add("Avocado");
                options.add("Tuna");
                options.add("Peanuts");
                break;

            case VEGAN:
                options.add("Avocado");
                options.add("Peanuts");
                break;

            case NUT_ALLERGY:
                options.add("Avocado");
                options.add("Sour cream");
                options.add("Tuna");
                break;
        }

        return options.get(random.nextInt(options.size()));
    }
}
