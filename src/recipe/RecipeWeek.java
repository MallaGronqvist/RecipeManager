package recipe;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class RecipeWeek {
    Map<LocalDate, Recipe> dayRecipeMapping = new LinkedHashMap<>();

    public void makeWeek(ArrayList<LocalDate> dates, ArrayList<Recipe> recipes){
        int index = 0;
        for (LocalDate date: dates) {
            dayRecipeMapping.put(date, recipes.get(index));
            index++;
        }
    }

    public Map<LocalDate, Recipe> getDayRecipeMapping() {
        return dayRecipeMapping;
    }
}
