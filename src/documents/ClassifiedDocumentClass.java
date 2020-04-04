package documents;

import users.*;

public class ClassifiedDocumentClass extends DocumentAbstractClass implements ClassifiedDocument {

    /**
     * User collection that stores the users that have permission to access a specific document
     * out of their default permission range.
     */
    UserCollection grants = new UserCollectionClass();
    
    /**
     * Constructor of the Classified Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    public ClassifiedDocumentClass(String ID, String description, User manager) {
        super(ID, description, manager);
    }

    @Override
    public void grant(User user) {
        grants.addUser(user);
    }

    
}
