// A prototype database for saving the single user's all recipe weeks
// so that they don't disappear when user logs out.

package recipe;

import java.util.HashMap;
import java.util.Map;

public class RecipeWeekDatabase {
    private static Map<Integer, RecipeWeek> usersRecipeWeeks = new HashMap<>();

    public static void saveUsersRecipeWeeks(Map<Integer, RecipeWeek> usersRecipeWeekMap){
        usersRecipeWeekMap = usersRecipeWeekMap;
    }

    public static Map<Integer, RecipeWeek> getUsersRecipeWeeks() {
        return usersRecipeWeeks;
    }
}
