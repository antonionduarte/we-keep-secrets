package actions;

import users.*;

public class ActionClass implements Action {

	private User relatedUser;
	private Actions action;
	private boolean revoked; // This only applies to grant actions

	/**
	 * Constructs a new instance. this constructor is used when a Grant action is executed.
	 * @param relatedUser  The affected user
	 * @param action        The action
	 */
	public ActionClass(User relatedUser, Actions action) {
		this.relatedUser = relatedUser;
		this.action = action;
		this.revoked = false;
	}

	/**
	 * Gets the User that the action is related with.
	 * @return     The affected user.
	 */
	public User getRelatedUser() {
		return relatedUser;
	}

	/**
	 * Gets the action type.
	 *
	 * @return     The action type.
	 */
	public Actions getActionType() {
		return actionType;
	}

	/**
	 * Revokes the action. This only applies to Grant actions.
	 */
	public void revoke() {
		this.revoked = true;
	}

	/**
	 * Determines if action was revoked. Only available for Grant actions
	 *
	 * @return     True if revoked, False otherwise.
	 */
	public boolean isRevoked() {
		return revoked;
	}
}