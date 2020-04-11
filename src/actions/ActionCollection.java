package actions;

import iterators.*;
import users.User;

public class ActionCollectionClass implements ActionCollection {

	private static final int DEFAULT_VECTOR_SIZE = 10;
	private static final int GROWTH_FACTOR = 2;

	private Action[] actions;
	private int actionCounter;
	private boolean isOfficial;

	public ActionCollectionClass(boolean isOfficial) {
		actions = new ActionClass[DEFAULT_VECTOR_SIZE];
		actionCounter = 0;
		this.isOfficial = isOfficial;
	}

	/**
	 * Adds an action. This method is restricted to Grant commands
	 *
	 * @param      issuer      The creator user
	 * @param      affected    The affected user
	 * @param      actionType  The action type
	 */
	public void addAction(User creator, User affected, Actions actionType) {
		Action action = new ActionClass(issuer, affected, actionType);
		if (isFull()) {
			if (isOfficial()) {
				insertDeleteLast(action);
			} else {
				resize();
				insert(action);
			}

		} else
			insert(action);
	}

	/**
	 * Adds an action. This method is restricted to Write or Read actions
	 *
	 * @param      issuer      The creator user
	 * @param      actionType  The action type
	 */
	public void addAction(User creator, Actions actionType) {
		Action action = new ActionClass(issuer, actionType);
		if (isFull()) {
			if (isOfficial()) {
				insertDeleteLast(action);
			} else {
				resize();
				insert(action);
			}

		} else
			insert(action);
	}

	/**
	 * Initiates an action iterator with a filter
	 *
	 * @return     An iterator object
	 */
	public Iterator actionIterator() {
		return new ActionIteratorClass(actions, actionCounter);
	}

	/**
	 * Determines if array is full.
	 *
	 * @return     True if full, False otherwise.
	 */
	private boolean isFull() {
		return actions.length == actionCounter;
	}

	/**
	 * Resizes the array. This method is only available for classified documents. Remmember that official documents only store the last 10 reads so they don't require resize.
	 */
	private void resize() {
		Action[] temp = new ActionClass[actions.length * GROWTH_FACTOR];
		for (int i=0 ; i<actionCounter ; i++) {
			temp[i] = actions[i];
		}
		actions = temp;
	}

	/**
	 * Inserts a new action in the array and deletes the oldest one.
	 *
	 * @param      action  The action
	 */
	private void insertDeleteLast(Action action) {
		for (int i=0 ; i<actionCounter-1 ; i++) {
			actions[i] = actions[i+1];
		}
		insert(action);
		actionCounter--;
	}

	/**
	 * Inserts a new action in the array.
	 *
	 * @param      action  The action
	 */
	private void insert(Action action) {
		actions[actionCounter++] = action;
	}
}