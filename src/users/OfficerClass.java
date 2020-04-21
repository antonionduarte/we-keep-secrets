package users;

import documents.*;
import clearance.*;

/**
 * This class describes an officer class.
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public class OfficerClass extends UserAbstractClass implements Officer {

    private int grantCount;

    private int revokeCount;

    public OfficerClass(String userKind, String userID, Clearance clearance) {
        super(userKind, userID, clearance);
        grantCount = 0;
        revokeCount = 0;
    }

    @Override
    public boolean hasGrant(String documentID, User user) {
        return getUploadedDocs().hasGrant(documentID, user);
    }

    @Override
    public boolean isRevoked(String documentID, User user) {
        return getUploadedDocs().isRevoked(documentID, user);
    }

    @Override
    public void write(ClassifiedDocument document, User writer, String description) {
    	document.setDescription(description, writer);
    }

    @Override
    public void grant(String documentID, User user) {
        Document document = getDocument(documentID);
        if (document instanceof ClassifiedDocument)
            ((ClassifiedDocument) document).grant(user);
        grantCount++;
    }

    @Override
    public void revoke(String documentID, User user) {
        Document document = getDocument(documentID);
        if (document instanceof ClassifiedDocument)
            ((ClassifiedDocument) document).revoke(user);
        revokeCount++;
    }

    @Override
    public int getGrantCount() {
        return grantCount;
    }

    @Override 
    public int getRevokeCount() {
        return revokeCount;
    }
}