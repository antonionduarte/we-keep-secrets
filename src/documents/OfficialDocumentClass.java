package documents;

import users.*;
import clearance.*;

public class OfficialDocumentClass extends AbstractDocument implements OfficialDocument {

    /**
     * Constructor of the Official Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    public OfficialDocumentClass(String ID, String description, User manager, Clearance clearance) {
        super(ID, description, manager, clearance);
    }
}
