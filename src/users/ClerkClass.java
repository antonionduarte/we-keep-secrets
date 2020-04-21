package users;

import clearance.*;

/**
 * This class describes a clerk class.
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public class ClerkClass extends UserAbstractClass implements Clerk {

    public ClerkClass(String userKind, String userID, Clearance clearance) {
        super(userKind, userID, clearance);
    }
}
