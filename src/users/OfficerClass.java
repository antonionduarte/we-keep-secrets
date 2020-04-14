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
    public void write(Document document, String message) {
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

    @Override
    public int getGrantCount() {
        return grantCount;
    }
}