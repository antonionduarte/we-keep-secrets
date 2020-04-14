package users;

import iterators.*;

public interface UserCollection {
	
	/**
	 * Removes a user from the array.
	 * @param user to remove from the array.
	 */
	void removeUser(User user);

	/**
	 * Adds a user to the collection.
	 * @param user to add to the collection.
	 */
	void addUser(User user);

	/**
	 * Returns the object of a user with the specified ID.
	 * @param userID of the user to get the object of.
	 * @return the object of the user with the specified <code>userID</code>.
	 */
	User getUserObject(String userID);

	/**
	 * Checks if the user with the specified <code>userID</code> is in the collection.
	 * @param userID of the User whose existance in the collection we wish to verify.
	 * @return true if there is a User in the colection with the specified <code>userID</code>.
	 */
	boolean hasUser(String userID);

	/**
	 * Returns an iterator of Users.
	 * @return an Iterator of the Users in the Collection.
	 */
	Iterator<User> userIterator();

}
