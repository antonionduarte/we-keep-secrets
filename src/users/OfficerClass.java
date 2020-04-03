package users;

import iterators.*;
import documents.*;

public class OfficerClass extends UserAbstractClass {

    public OfficerClass(String userKind, String userID, int clearance) {
        super(userKind, userID, clearance);
    }

    public void write(Document document, String message) {
    	document.write(message);
    }

    public void grant(Document document, User user) {
    	document.grant(user);
    }

    public void revoke(Document document, User user) {
    	document.revoke(user);
    }
}