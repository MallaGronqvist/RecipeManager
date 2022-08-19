package printers;

import java.io.IOException;
import java.util.List;

public class PrintHandler {
    public static void appTitle() {
        System.out.println("Recipe Manager");
    }

    public static void clearConsole() {
        String operatingSystem = System.getProperty("os.name");

        if (operatingSystem.equals("Windows")) {
            clearConsoleWindows();
        }
        else {
            clearConsoleUnix();
        }
    }

    public static void optionBackToMainMenu() {
        System.out.println("[0] Back to main menu");
    }

    public static void optionList(List<?> options) {
        for (int index = 0; index < options.size(); index++) {
            int number = index + 1;

            System.out.println("[" + number + "] " + options.get(index));
        }
    }

    private static void clearConsoleUnix() {
        String clearScreenASCIICode = "\033[H\033[2J";

        System.out.print(clearScreenASCIICode);
        System.out.flush();
    }

    private static void clearConsoleWindows() {

        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (IOException | InterruptedException e) {
            String errorMessage = "An unexpected error has occurred, which may result in the program " +
                    "not displaying correctly.";
            System.out.println(errorMessage);
        }
    }


}
