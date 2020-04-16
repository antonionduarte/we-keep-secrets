package actions;

import users.User;

public interface Action {

	/**
	 * In the Actions what happens is that we are storing a User that the action is related with and it's type.
	 * 
	 * In the Write and Read actions the related user is the one who read or wrote on the document.
	 * 
	 * In the Grant and Revoke actions the related user is the one who got the Document granted
	 * or revoked from them. (This is also the basis of our grant system).
	 */

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

	/**
	 * 
	 */
	void revoke();

	/**
	 * 
	 * @return true if it has been revoked, false if otherwise.
	 */
	boolean isRevoked();
}