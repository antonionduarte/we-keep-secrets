package documents;

import users.*;

public class OfficialDocumentClass extends DocumentAbstractClass {

    public OfficialDocumentClass(String ID, String description, User manager) {
        super(ID, description, manager);
    }
}
