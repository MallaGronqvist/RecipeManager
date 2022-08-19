package userRoles;

import dietitianMenu.DietitianMenu;

public class Dietitian extends Person {
    @Override
    public void printBanner() {
        System.out.println("Inlogged as dietitian.");
    }

    @Override
    public void sessionLoop() {

        new DietitianMenu();
    }
}
