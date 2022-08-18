package userRoles;

import userRoles.Person;

public class User extends Person {
    @Override
    void sessionLoop() {
        System.out.println("Inlogged as user.");
    }
}
