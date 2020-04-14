package users;

import clearance.*;

public class ClerkClass extends UserAbstractClass implements Clerk {

    public ClerkClass(String userKind, String userID, Clearance clearance) {
        super(userKind, userID, clearance);
    }
    
}
