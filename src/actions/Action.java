package actions;

import users.User;

public interface Action {

	abstract User getActionCreator();

	abstract User getAffectedUser();

	abstract Actions getActionType();

	abstract void revoke();

	abstract boolean isRevoked();
}