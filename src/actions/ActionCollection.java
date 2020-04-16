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
    User getRelatedUser();

    // TODO: Finish this tomorrow.

}