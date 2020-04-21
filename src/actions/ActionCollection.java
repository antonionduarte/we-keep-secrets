package actions;

import users.*;
import iterators.*;

/**
 * This interface describes a collection of actions.
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public interface ActionCollection {

    /**
     * Adds an action to the collection.
     * Pre: relatedUser != NULL && actionType != NULL
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
     * Checks if a specific user has a grant to a document.
     * Pre: user != NULL
     * @param user to check for.
     * @return true if the user has an active grant to a document, false if otherwise.
     */
    boolean hasGrant(User user);

    /**
     * Checks if a specific user is revoked to a document.
     * Pre: user != NULL
     * @param user to check for.
     * @return true if the user has an active revoke to a document, false if otherwise.
     */
    boolean isRevoked(User user);
}