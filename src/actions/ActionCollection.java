package actions;

import users.*;
import iterators.*;

public interface ActionCollection {

    /**
     * Adds an action to the collection.
     * @param relatedUser the user related to the action.
     * @param actionType the type of the action.
     */
    void addAction(User relatedUser, Actions actionType);

    /**
     * Initiates an iterator of Actions. The parameter <code>reverse</code> allows the user to reverse the actions array. This is useful because the read and writes must be displayed from newest to oldest (reverse order).
     * @param reverse If true reverses the action array, if false does nothing
     * @return iterator of actions.
     */
    Iterator<Action> actionIterator(boolean reverse);

    /**
     * Gets the user related to the action.
     * @return user related to the action.
     */
    User getRelatedUser(int actionIndex);

    /**
     * Checks if a specific user has a grant to a document.
     * @param user to check for.
     * @return true if the user has an active grant to a document, false if otherwise.
     */
    boolean hasGrant(User user);

    /**
     * Checks if a specific user is revoked to a document.
     * @param user to check for.
     * @return true if the user has an active revoke to a document, false if otherwise.
     */
    boolean isRevoked(User user);
}