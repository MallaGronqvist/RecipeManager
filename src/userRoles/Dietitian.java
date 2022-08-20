package userRoles;

import dietitianMenu.DietitianMenu;

public class Dietitian extends Person {
    @Override
    public void printBanner() {
        System.out.println("Logged in as dietitian.");
        System.out.println();
    }

    @Override
    public void sessionLoop() {

        new DietitianMenu();
    }
}
