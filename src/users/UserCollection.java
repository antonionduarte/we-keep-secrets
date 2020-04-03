package users;

import documents.*;
import iterators.*;

public interface UserCollection {

	abstract void addUser(User user);

	abstract User getUserObject(String userID);
	
	abstract void upload(User user, Document document);

	abstract boolean hasUser(String userID);

}
