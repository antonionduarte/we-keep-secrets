package documents;

import clearance.*;
import users.*;

public class OfficialDocumentClass extends AbstractDocument implements OfficialDocument {

    /**
     * Constructor of the Official Documents.
     * PRE: ID != NULL && description != NULL && clearance != NULL
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param clearance access level of the document.
     */
    public OfficialDocumentClass(String ID, String description, Clearance clearance, User manager) {
        super(ID, description, clearance, manager);
    }
}
