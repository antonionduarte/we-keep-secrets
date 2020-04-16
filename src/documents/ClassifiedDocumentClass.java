package documents;

import clearance.*;
import users.*;

public class ClassifiedDocumentClass extends AbstractDocument implements ClassifiedDocument {
    
    /**
     * Constructor of the Classified Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    public ClassifiedDocumentClass(String ID, String description, User manager, Clearance clearance) {
        super(ID, description, manager, clearance);
    }
}
