package actions;

import iterators.*;
import users.*;

/**
 * This class describes an action collection class.
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public class ActionCollectionClass implements ActionCollection {

	private static final int DEFAULT_VECTOR_SIZE = 10;
	private static final int GROWTH_FACTOR = 2;

	/**
	 * The array of actions.
	 */
	private Action[] actions;

	/**
	 * The counter of the action array.
	 */
	private int actionCounter;

	// Public methods.

	/**
	 * Constructor of ActionCollectionClass.
	 */
	public ActionCollectionClass() {
		actions = new ActionClass[DEFAULT_VECTOR_SIZE];
		actionCounter = 0;
	}

	@Override
	public void addAction(User relatedUser, Actions actionType) {
		Action action = new ActionClass(relatedUser, actionType);
		if (isFull()) {
			resize();
		}
		actions[actionCounter++] = action;
	}

	@Override
	public Iterator<Action> actionIterator() {
		return new IteratorClass<Action>(actions, actionCounter);
	}

	@Override
	public boolean hasGrant(User user) {
		boolean hasGrant = false;
		for (int i = actionCounter - 1; (i >= 0) && (!hasGrant); i--) {
			if (actions[i].getRelatedUser().equals(user)) {
				if (actions[i].getActionType().equals(Actions.REVOKE)) hasGrant = false;
				else if (actions[i].getActionType().equals(Actions.GRANT)) hasGrant = true;
			}
		}
		return hasGrant;
	}

	@Override
	public boolean isRevoked(User user) {
		boolean isRevoked = false;
		for (int i = actionCounter - 1; (i > 0) && (!isRevoked); i--) {
			if (actions[i].getRelatedUser().equals(user)) {
				if (actions[i].getActionType().equals(Actions.REVOKE)) isRevoked = true;
				else if (actions[i].getActionType().equals(Actions.GRANT)) isRevoked = false;
			}
		}
		return isRevoked;
	}

	// Private methods.

	/**
	 * Determines if the array is full.
	 * @return true if the array is full, false if otherwise.
	 */
	private boolean isFull() {
		return actions.length == actionCounter;
	}

	/**
	 * Resize the array. This method is only available for classified documents.
	 */
	private void resize() {
		Action[] temp = new ActionClass[actions.length * GROWTH_FACTOR];
		for (int i = 0; i < actionCounter; i++)
			temp[i] = actions[i];
		actions = temp;
	}
}