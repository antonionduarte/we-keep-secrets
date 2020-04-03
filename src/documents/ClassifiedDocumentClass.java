package documents;

import users.*;

public class ClassifiedDocumentClass extends DocumentAbstractClass {

    
    /**
     * Constructor of the Classified Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    public ClassifiedDocumentClass(String ID, String description, User manager) {
        super(ID, description, manager);
    }
}
