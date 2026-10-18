package macronutrients;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProteinFactory {

    private static final ProteinFactory instance = new ProteinFactory();
    private final Random random = new Random();

    private ProteinFactory(){

    }

    public static ProteinFactory getInstance() {
        return instance;
    }

    public String createProtein(Customer.DietPlan dietPlan){
        List<String> options = new ArrayList<>();

        switch (dietPlan){

            case NO_RESTRICTION:
                options.add("Fish");
                options.add("Chicken");
                options.add("Beef");
                options.add("Tofu");
                break;

            case PALEO:
                options.add("Fish");
                options.add("Chicken");
                options.add("Beef");
                break;

            case VEGAN:
                options.add("Tofu");
                break;

            case NUT_ALLERGY:
                options.add("Fish");
                options.add("Chicken");
                options.add("Beef");
                options.add("Tofu");
                break;
        }

        return options.get(random.nextInt(options.size()));
    }
}
