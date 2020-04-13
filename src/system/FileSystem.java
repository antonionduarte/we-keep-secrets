package system;

import documents.*;
import users.*;
import iterators.*;
import clearance.*;

public interface FileSystem {

	abstract void register(String userKind, String userID, Clearance clearance);

	abstract Iterator listUsers();

	abstract void upload(String docID, String userID, Clearance clearance, String description);

	abstract void write(String docID, String managerID, String userID, String description);

	abstract boolean userExists(String userID);

	abstract boolean userHasDocument(String userID, String docID);

	abstract boolean hasGrant(String userID, String docID);

	abstract boolean isOfficial(String docID);

	abstract Clearance getUserClearance(String userID);

	abstract Clearance getDocumentClearance(String docID);
}
