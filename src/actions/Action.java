package actions;

import users.User;

public interface Action {

	// TODO: This doesn't need to neccessarily be like this.
	// There are two actions, an action of grants and revokes // action of reads and writes.
	// Each document must have a collection for reads and writes and grants and revokes.
	// In the reads and writes the User that accessed the document and the action is stored.
	// In the grants and revoked the User that 

	/**
	 * Returns the creator of an action.
	 * @return the User who made a specific action.
	 */
	User getActionCreator();

	/**
	 * 
	 * @return the User who got affected by the action.
	 */
	User getAffectedUser();

	/**
	 * 
	 * @return
	 */
	Actions getActionType();

	void revoke();

	boolean isRevoked();
}