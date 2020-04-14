package actions;

import users.*;

public class ActionClass implements Action {

	private User creator;
	private User affectedUser; // Only available in grant actions. Writes and reads only have the creator
	private Actions actionType;
	private boolean revoked; // This only applies to grant actions

	/**
	 * Constructs a new instance. this constructor is used when a Grant action is executed.
	 *
	 * @param      creator       The creator
	 * @param      affectedUser  The affected user
	 * @param      action        The action
	 */
	public ActionClass(User creator, User affectedUser, Actions actionType) {
		this.creator = creator;
		this.affectedUser = affectedUser;
		this.actionType = actionType;
		this.revoked = false;
	}

	/**
	 * Constructs a new instance. This constructor is used when a Write or Read action in executed
	 *
	 * @param      creator  The creator
	 * @param      action   The action
	 */
	public ActionClass(User creator, Actions action) {
		this.creator = creator;
		this.action = action;
	}

	/**
	 * Gets the action creator.
	 *
	 * @return     The action creator.
	 */
	public User getActionCreator() {
		return creator;
	}

	/**
	 * Gets the affected user.
	 *
	 * @return     The affected user.
	 */
	public User getAffectedUser() {
		return affectedUser;
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