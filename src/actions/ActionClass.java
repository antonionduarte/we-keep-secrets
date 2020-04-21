package actions;

import users.*;

public class ActionClass implements Action {

	private User relatedUser;
	private Actions action;

	/**
	 * Constructs a new instance. this constructor is used when a Grant action is executed.
	 * @param relatedUser the user that is related to the action. In case of Grant/Revoke actions it's the User that the
	 * grant was issued or revoked to. In case of Read/Write actions it's the one who read or wrote in the document.
	 * @param action the action type.
	 * Pre: relatedUser != NULL && action != NULL
	 */
	public ActionClass(User relatedUser, Actions action) {
		this.relatedUser = relatedUser;
		this.action = action;
	}

	@Override
	public User getRelatedUser() {
		return relatedUser;
	}

	@Override
	public Actions getActionType() {
		return action;
	}
}