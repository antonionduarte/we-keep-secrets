package users;

import documents.*;

public interface Officer extends User {

	void write(Document document, String message);

	void grant(Document document, User user);

	void revoke(Document document, User user);

}