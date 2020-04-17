package users;

import documents.*;
import clearance.*;

public class OfficerClass extends UserAbstractClass implements Officer {

    private int grantCount;

    public OfficerClass(String userKind, String userID, Clearance clearance) {
        super(userKind, userID, clearance);

        grantCount = 0;
    }

    @Override
    public void write(User relatedUser, String documentID, String description) {
    	document.setDescription(message);
    }

    @Override
    public void grant(ClassifiedDocument document, User user) {
    	document.grant(user);
        grantCount++;
    }

    @Override
    public void revoke(ClassifiedDocument document, User user) {
    	document.revoke(user);
    }
}