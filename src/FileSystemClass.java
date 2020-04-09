import documents.*;
import users.*;
import iterators.*;
import clearance.*;

public class FileSystemClass implements FileSystem {

    User managerLol;

    DocumentCollection documentCollection;
    UserCollection userCollection;

    public FileSystemClass() {
        documentCollection = new DocumentCollectionClass();
        userCollection = new UserCollectionClass();
    }

    /**
     * (TEMP) upload <doc_name> <user_id> <security_level> <description>
     * TODO: replace managerLol lmao.
     */
    public void createDocument(String ID, String managerID, String clearance, String description) {

        User manager = userCollection.searchIndex(managerID);

        if (clearance.equals(Clearance.CLERK.getClearanceString())) {
            OfficialDocument document = new OfficialDocumentClass(ID, description, managerLol, Clearance.CLERK);
        } else if (clearance.equals(Clearance.CONFIDENTIAL.getClearanceString())) {
            ClassifiedDocument document = new ClassifiedDocumentClass(ID, description, managerLol, Clearance.CONFIDENTIAL);
        } else if (clearance.equals(Clearance.SECRET.getClearanceString())) {
            ClassifiedDocument document = new ClassifiedDocumentClass(ID, description, managerLol, Clearance.SECRET);
        } else {
            ClassifiedDocument document = new ClassifiedDocumentClass(ID, description, managerLol, Clearance.TOPSECRET);
        }
        
        documentCollection.addDocument(document);
    }

    public void register(String userKind, String userID, Clearance clearance) {
    	User user = new User(userKind, userID, clearance);
    	uc.addUser(user);
    }

    public Iterator listUsers() {
    	return us.userIterator();
    }

    public void upload(String docID, String userID, Clearance clearance, String description) {
    	User user = uc.getUserObject(userID);
    	Document doc = new Document(docID, description, user, clearance);
    	dc.addDocument(doc);
    }

    public void write(String docID, String managerID, String userID, String description) {
    	Document doc = dc.getDocumentObject(docID);
    	doc.write(description)
    	// TODO: Document has to log the operation
    }

    public boolean userExists(String userID) {
    	uc.hasUser(userID);
    }

    public boolean userHasDocument(String userId, String docID) {
    	User user = uc.getUserObject(String userID);
    	return user.hasDocument(docID);
    }

 	public boolean hasClearance(String userID, String docID) {
 		User user = us.getUserObject(userID);
 		Document doc = dc.getDocumentObject(docID);
 		return user.getClearance().toInt() >= doc.getClearance().toInt()
 	}

 	public boolean hasGrant(String userID, String docID) {
 		Document doc = dc.getDocumentObject(docID);
 		return doc.hasGrant(userID);
 	}

 	public boolean isOfficial(String docID) {
 		return dc.getDocumentObject(docID).getClearance().toInt() == Clerance.CLERK.toInt();
 	}

    public Clearance getUserClearance(String userID) {
    	uc.getUserObject(userID).getClerance();
    }

    public Clearance getDocumentClearance(String documentID) {
    	dc.getDocumentObject(documentID).getClerance();
    }
}
