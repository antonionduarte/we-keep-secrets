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
			if (relatedDocument.getClearance().toInt() == Clearance.CLERK.toInt())
				insertDeleteLast(action);
			else {
				resize();
				insert(action);
			}
		} else
			insert(action);
	}

	@Override
	public Iterator<Action> actionIterator() {
		return new IteratorClass<Action>(actions, actionCounter);
	}

	/**
	 * Determines if the array is full.
	 * @return true if the array is full, false if otherwise.
	 */
	private boolean isFull() {
		return actions.length == actionCounter;
	}

	/**
	 * Resizes the array. This method is only available for classified documents.
	 */
	private void resize() {
		Action[] temp = new ActionClass[actions.length * GROWTH_FACTOR];
		for (int i = 0; i < actionCounter; i++)
			temp[i] = actions[i];
		actions = temp;
	}

	/**
	 * Inserts a new action by deleting the last inserted action.
	 * @param action the action to insert.
	 */
	private void insertDeleteLast(Action action) {
		for (int i = 0; i < actionCounter - 1; i++)
			actions[i] = actions[++i];
		insert(action);
		actionCounter--;
	}

	/**
	 * Inserts a new action in the array.
	 * @param action the action to insert.
	 */
	private void insert(Action action) {
		actions[actionCounter++] = action;
	}

	@Override
	public User getRelatedUser(int actionIndex) {
		return actions[actionIndex].getRelatedUser();
	}
}