package actions;

import iterators.*;
import users.*;
import documents.*;
import clearance.*;

public class ActionCollectionClass implements ActionCollection {

	private static final int DEFAULT_VECTOR_SIZE = 10;
	private static final int GROWTH_FACTOR = 2;

	private Action[] actions;
	private Document relatedDocument;
	private int actionCounter;

	// Public methods.

	/**
	 * Constructor of ActionCollectionClass.
	 * @param relatedDocument document related to the collection.
	 */
	public ActionCollectionClass(Document relatedDocument) {
		actions = new ActionClass[DEFAULT_VECTOR_SIZE];
		this.relatedDocument = relatedDocument;
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
	public Iterator<Action> actionIterator(boolean reverse) {
		if (reverse) {
			// Reverse the order
			Action[] temp = new Action[actions.length];
			int j = 0;
			for (int i=actionCounter-1 ; i>=0 ; i--)
				temp[j++] = actions[i];
			return new IteratorClass<Action>(temp, actionCounter);
		}
		return new IteratorClass<Action>(actions, actionCounter);

		
	}

	@Override
	public User getRelatedUser(int actionIndex) {
		return actions[actionIndex].getRelatedUser();
	}

	@Override
	public boolean hasGrant(User user) {
		boolean hasGrant = false;
		for (int i = actionCounter - 1; (i > 0) && (hasGrant == false); i--) {
			if (actions[i].getRelatedUser().equals(user)) {
				if (actions[i].getActionType().equals(Actions.REVOKE)) hasGrant = false;
				else if (actions[i].getActionType().equals(Actions.GRANT)) hasGrant = true;
			}
		}
		return hasGrant;
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