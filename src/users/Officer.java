package users;

import documents.*;

public interface HighPrevillegeUser extends User implements Officer {

	abstract void write(Document document, String message);

	abstract void grant(Document document, User user);

	abstract void revoke(Document document, User user);

}