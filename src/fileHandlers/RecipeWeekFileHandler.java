package fileHandlers;

import recipe.Recipe;
import recipe.RecipeWeek;

import java.io.*;
import java.time.DayOfWeek;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RecipeWeekFileHandler {
    private static Map<Integer, RecipeWeek> usersRecipeWeekMap = new HashMap<>();

    public static void saveUsersRecipeWeeks(Map<Integer, RecipeWeek> usersRecipeWeekMap){
        RecipeWeekFileHandler.usersRecipeWeekMap = usersRecipeWeekMap;
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
        List<String> lines = new ArrayList<>();

        try (FileReader fileReader = new FileReader("assets/recipeWeeks.txt");
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

        } catch (IOException | IndexOutOfBoundsException e) {
            System.out.println("Recipe weeks could not be loaded from file.");
            usersRecipeWeekMap = new HashMap<>();
        }

        int weekDataSize = 8;
        final AtomicInteger counter = new AtomicInteger();

        List<List<String>> parsedWeeks = lines.stream().
                collect(Collectors.groupingBy(item -> counter.getAndIncrement() / weekDataSize))
                .values().stream().toList();

        for (List<String> weekData: parsedWeeks) {
            String[] parsedData = weekData.toArray(new String[8]);
            Integer weekNumber = Integer.parseInt(parsedData[0]);
            usersRecipeWeekMap.put(weekNumber, new RecipeWeek(parsedData));
        }
    }
}
