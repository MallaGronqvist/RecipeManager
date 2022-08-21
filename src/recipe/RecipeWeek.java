package recipe;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;

public class RecipeWeek {
    Map<LocalDate, Recipe> dayRecipeMapping = new LinkedHashMap<>();
    int weekId;

    public RecipeWeek(List<LocalDate> dates, List<Recipe> recipes){
        int index = 0;

        for (LocalDate date: dates) {
            dayRecipeMapping.put(date, recipes.get(index));
            index++;
        }
    }

    public Map<LocalDate, Recipe> getDayRecipeMapping() {
        return dayRecipeMapping;
    }

    public void setWeekId(int weekId) {
        this.weekId = weekId;
    }

    public int getWeekId() {
        return weekId;
    }

    public Recipe getRecipeByDay(DayOfWeek day){
        Recipe recipe = new Recipe();

        for (LocalDate date: dayRecipeMapping.keySet()) {   // Change to stream?
            if(date.getDayOfWeek() == day){
                recipe = dayRecipeMapping.get(date);
            }
        }
        return recipe;
    }

    public Recipe getRecipeByDate(LocalDate date){
        return dayRecipeMapping.get(date);
    }

}
