package users;

import iterators.*;
import documents.*;
import clearance.*;

public class ClerkClass extends UserAbstractClass {

    public ClerkClass(String userKind, String userID, Clearance clearance) {
        super(userKind, userID, clearance);
    }
}
