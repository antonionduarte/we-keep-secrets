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
	 * Returns the User that is related to the action.
	 * In case of Grant or Revoke actions it's the User that the Document will be Granted to or Revoked from.
	 * In case of Read or Write actions it's the User that read or wrote to the document.
	 * @return the User that is related to the action.
	 */
	User getRelatedUser();

	/**
	 * Returns the type of the action.
	 * @return the type of the action (read, write, grant, revoke).
	 */
	Actions getActionType();
}