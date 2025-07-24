interface MealPlan {
    String getType();
}

class VegetarianMeal implements MealPlan {
    public String getType() { return "Vegetarian"; }
}

class VeganMeal implements MealPlan {
    public String getType() { return "Vegan"; }
}

class KetoMeal implements MealPlan {
    public String getType() { return "Keto"; }
}

class Meal<T extends MealPlan> {
    private T mealType;
    public Meal(T mealType) { this.mealType = mealType; }
    public T getMealType() { return mealType; }
}

class MealUtil {
    public static <T extends MealPlan> void generateMealPlan(Meal<T> meal) {
        System.out.println("Generating meal plan for: " + meal.getMealType().getType());
    }
}

public class PersonalizedMealPlanGenerator {
    public static void main(String[] args) {
        Meal<VeganMeal> vegan = new Meal<>(new VeganMeal());
        MealUtil.generateMealPlan(vegan);
    }
}