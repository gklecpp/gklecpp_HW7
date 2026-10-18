package macronutrients;

public abstract class MacronutrientFactory {

    private static final MacronutrientFactory instance = new DefaultMacronutrientFactory();

    protected MacronutrientFactory(){

    }

    public static MacronutrientFactory getInstance(){
        return instance;
    }

    public abstract String createCarbs(Customer.DietPlan dietPlan);

    public abstract String createProtein(Customer.DietPlan dietPlan);

    public abstract String createFats(Customer.DietPlan dietPlan);

    private static class DefaultMacronutrientFactory extends MacronutrientFactory{

        private DefaultMacronutrientFactory(){

        }

        @Override
        public String createCarbs(Customer.DietPlan dietPlan){
            return CarbsFactory.getInstance().createCarbs(dietPlan);
        }

        @Override
        public String createProtein(Customer.DietPlan dietPlan){
            return ProteinFactory.getInstance().createProtein(dietPlan);
        }

        @Override
        public String createFats(Customer.DietPlan dietPlan){
            return FatsFactory.getInstance().createFats(dietPlan);
        }
    }


}
