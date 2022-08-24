// A prototype database for saving the single user's all recipe weeks
// so that they don't disappear when user logs out.

package recipe;

import java.io.*;
import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RecipeWeekDatabase {
    private static Map<Integer, RecipeWeek> usersRecipeWeekMap = new HashMap<>();

    public static void saveUsersRecipeWeeks(Map<Integer, RecipeWeek> usersRecipeWeekMap){
        RecipeWeekDatabase.usersRecipeWeekMap = usersRecipeWeekMap;
        saveToFile();
    }

    public static Map<Integer, RecipeWeek> getUsersRecipeWeekMap() {
        readFromFile();

        return usersRecipeWeekMap;
    }

    public static void saveToFile(){
        try (Writer output = new BufferedWriter(new FileWriter("assets/recipeWeeks.txt"))){


            for (Integer weekNumber: usersRecipeWeekMap.keySet()) {
                output.write(String.valueOf(weekNumber));
                output.write("\n");
                RecipeWeek recipeWeek = usersRecipeWeekMap.get(weekNumber);
                Map<DayOfWeek, Recipe> dayRecipeMapping = recipeWeek.getDayRecipeMapping();
                for(DayOfWeek day : dayRecipeMapping.keySet()){
                    output.write(dayRecipeMapping.get(day).printable());
                }
            }

        } catch (IOException e) {
            System.out.println("Couldn't save recipe weeks to file.");
        }
    }

    public static void readFromFile(){

        try (FileReader fileReader = new FileReader("assets/recipeWeeks.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            List<String> lines = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
                //   RecipeWeek recipeWeek = new RecipeWeek(parsedData);
                //    usersRecipeWeekMap.put(recipeWeek.getWeekNumber(), recipeWeek);
            }
            int chunkSize = 8;
            final AtomicInteger counter = new AtomicInteger();

            List<List<String>> parsedWeeks= new ArrayList<>();
            parsedWeeks = lines.stream().collect(Collectors.groupingBy(item -> counter.getAndIncrement() / chunkSize))
                    .values().stream().toList();

            RecipeWeek recipeWeek;
            for (List<String> weekData: parsedWeeks) {
                String[] parsedData = weekData.toArray(new String[8]);
                Integer weekNumber = Integer.parseInt(parsedData[0]);
                usersRecipeWeekMap.put(weekNumber, new RecipeWeek(parsedData));
            }


        } catch (IOException e) {
            System.out.println("Recipe weeks could not be loaded from file.");

            System.exit(0);
        }
    }
}
