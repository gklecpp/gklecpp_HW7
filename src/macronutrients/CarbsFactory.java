package macronutrients;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarbsFactory {
    private static final CarbsFactory instance = new CarbsFactory();
    private final Random random = new Random();

    private CarbsFactory(){

    }

    public static CarbsFactory getInstance(){
        return instance;
    }

    public String createCarbs(Customer.DietPlan dietPlan){
        List<String> options = new ArrayList<>();

        switch (dietPlan){
            case NO_RESTRICTION:
                options.add("Cheese");
                options.add("Bread");
                options.add("Lentils");
                options.add("Pistachio");
                break;

            case PALEO:
                options.add("Pistachio");
                break;

            case VEGAN:
                options.add("Bread");
                options.add("Lentils");
                options.add("Pistachio");
                break;

            case NUT_ALLERGY:
                options.add("Cheese");
                options.add("Bread");
                options.add("Lentils");
                break;
        }

        return options.get(random.nextInt(options.size()));
    }
}

