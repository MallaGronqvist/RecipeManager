package userRoles;

import userMenu.UserMenu;
import userRoles.Person;

public class User extends Person {
    @Override
    public void printBanner() {
        System.out.println("Logged in as user.");
    }

    @Override
    public void sessionLoop(){
        new UserMenu(this);
    }
}
