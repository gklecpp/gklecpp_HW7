package macronutrients;

public class Customer {

    public enum DietPlan{
        NO_RESTRICTION,
        PALEO,
        VEGAN,
        NUT_ALLERGY
    }

    private final String name;
    private final DietPlan dietPlan;

    public Customer(String name, DietPlan dietPlan){
        this.name = name;
        this.dietPlan = dietPlan;
    }

    public String getName(){
        return name;
    }

    public DietPlan getDietPlan() {
        return dietPlan;
    }
}
