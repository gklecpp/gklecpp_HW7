package macronutrients;

public class Meal {

    private final String carbs;
    private final String protein;
    private final String fats;

    public Meal(String carbs, String protein, String fats){
        this.carbs = carbs;
        this.protein = protein;
        this.fats = fats;
    }

    public void displayMeal(){
        System.out.println("Carbs: " + carbs);
        System.out.println("Protein: " + protein);
        System.out.println("Fats: " + fats);
        System.out.println();
    }
}
