package recipe;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class RecipeWeek {
    Map<DayOfWeek, Recipe> dayRecipeMapping = new LinkedHashMap<>();
    int weekNumber;

    public RecipeWeek(List<Recipe> recipes){
        int index = 0;

        for (DayOfWeek day: DayOfWeek.values()) {
            dayRecipeMapping.put(day, recipes.get(index));
            index++;
        }
    }

    public Map<DayOfWeek, Recipe> getDayRecipeMapping() {
        return dayRecipeMapping;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public Recipe getRecipeByDay(DayOfWeek requestedDay){

        return dayRecipeMapping.get(requestedDay);
    }
}
