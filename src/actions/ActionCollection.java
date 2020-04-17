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
     * Initiates an iterator of Actions.
     * @return iterator of actions.
     */
    Iterator<Action> actionIterator();

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
}