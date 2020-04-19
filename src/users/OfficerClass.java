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
    public void write(ClassifiedDocument document, User writer, String description) {
    	document.setDescription(description, writer);
    }

    @Override
    public void grant(String documentID, User user) {
        ClassifiedDocument document = (ClassifiedDocument) getDocument(documentID);
    	document.grant(user);
        grantCount++;
    }

    @Override
    public void revoke(String documentID, User user) {
        ClassifiedDocument document = (ClassifiedDocument) getDocument(documentID);
        document.revoke(user);
    }

    @Override
    public int getGrantCount() {
        return grantCount;
    }
}