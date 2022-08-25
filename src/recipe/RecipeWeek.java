package recipe;

import java.time.DayOfWeek;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RecipeWeek {
    Map<DayOfWeek, Recipe> dayRecipeMapping = new LinkedHashMap<>();
    int weekNumber;

    public RecipeWeek(List<Recipe> recipes) {
        int index = 0;

        for (DayOfWeek day : DayOfWeek.values()) {
            dayRecipeMapping.put(day, recipes.get(index));
            index++;
        }
    }

    public RecipeWeek(String[] parsedData) {
        setWeekNumber(Integer.parseInt(parsedData[0]));

        String[] parsedMonday = parsedData[1].split(":");
        dayRecipeMapping.put(DayOfWeek.MONDAY, new Recipe(parsedMonday));

        String[] parsedTuesday = parsedData[2].split(":");
        dayRecipeMapping.put(DayOfWeek.TUESDAY, new Recipe(parsedTuesday));

        String[] parsedWednesday = parsedData[3].split(":");
        dayRecipeMapping.put(DayOfWeek.WEDNESDAY, new Recipe(parsedWednesday));

        String[] parsedThursday = parsedData[4].split(":");
        dayRecipeMapping.put(DayOfWeek.THURSDAY, new Recipe(parsedThursday));

        String[] parsedFriday = parsedData[5].split(":");
        dayRecipeMapping.put(DayOfWeek.FRIDAY, new Recipe(parsedFriday));

        String[] parsedSaturday = parsedData[6].split(":");
        dayRecipeMapping.put(DayOfWeek.SATURDAY, new Recipe(parsedSaturday));

        String[] parsedSunday = parsedData[7].split(":");
        dayRecipeMapping.put(DayOfWeek.SUNDAY, new Recipe(parsedSunday));
    }

    public Map<DayOfWeek, Recipe> getDayRecipeMapping() {
        return dayRecipeMapping;
    }

    public int getWeekNumber() {
        return weekNumber;
    }

    public void setWeekNumber(int weekNumber) {
        this.weekNumber = weekNumber;
    }

    public Recipe getRecipeByDay(DayOfWeek requestedDay) {

        return dayRecipeMapping.get(requestedDay);
    }
}
