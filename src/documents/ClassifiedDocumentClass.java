package documents;

import clearance.*;
import users.*;
import actions.*;
import iterators.*;

public class ClassifiedDocumentClass extends AbstractDocument implements ClassifiedDocument {
    
    // Variables

    /**
     * ActionCollection that stores the grants and revokes.
     */
    private ActionCollection grantsRevokes;

    /**
     * Amount of times that the document has been granted.
     */
    private int grantCount;

    /**
     * Amount of times that the document has been revoked.
     */
    private int revokeCount;

    /**
     * Constructor of the Classified Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param clearance access level of the document.
     */
    public ClassifiedDocumentClass(String ID, String description, Clearance clearance, User manager) {
        super(ID, description, clearance, manager);
        grantsRevokes = new ActionCollectionClass();
    }

    @Override
    public void grant(User relatedUser) {
        grantsRevokes.addAction(relatedUser, Actions.GRANT);
        grantCount++;
    }

    @Override
    public int getGrantCount() {
        return grantCount;
    }

    @Override
    public void revoke(User relatedUser) {
        grantsRevokes.addAction(relatedUser, Actions.REVOKE);
        revokeCount++;
    }

    @Override 
    public int getRevokeCount() {
        return revokeCount;
    }

    @Override
    public boolean hasGrant(User user) {
        return grantsRevokes.hasGrant(user);
    }

    @Override
    public boolean isRevoked(User user) {
        return grantsRevokes.isRevoked(user);
    }

    @Override
    public Iterator<Action> documentGrantsRevokesIterator() {
        return grantsRevokes.actionIterator();
    }
}
