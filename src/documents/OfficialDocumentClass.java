package documents;

import users.*;

public class OfficialDocumentClass extends DocumentAbstractClass {

    /**
     * Constructor of the Official Documents.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    public OfficialDocumentClass(String ID, String description, User manager) {
        super(ID, description, manager);
    }
}
