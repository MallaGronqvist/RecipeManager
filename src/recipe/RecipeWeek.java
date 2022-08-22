package recipe;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RecipeWeek {
    Map<DayOfWeek, Recipe> dayRecipeMapping = new LinkedHashMap<>();
    int weekId;

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

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public int getWeekId() {
        return weekId;
    }

    public Recipe getRecipeByDay(DayOfWeek requestedDay){
     /*   Recipe recipe = new Recipe();

        for (DayOfWeek day: dayRecipeMapping.keySet()) {   // Change to stream?
            if(day == requestedDay){
                recipe = dayRecipeMapping.get(day);
            }
        }
        return recipe;

      */
        return dayRecipeMapping.get(requestedDay);
    }

    public Recipe getRecipeByDate(LocalDate date){
        return dayRecipeMapping.get(date);
    }

}
