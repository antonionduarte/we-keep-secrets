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
}
