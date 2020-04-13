package users;

import documents.*;
import iterators.*;

public interface UserCollection {
	
	/**
	 * Removes a user from the array.
	 * @param user to remove from the array.
	 */
	void removeUser(User user);

	abstract void addUser(User user);

	abstract User getUserObject(String userID);

	abstract boolean hasUser(String userID);

	abstract Iterator userIterator();

}
