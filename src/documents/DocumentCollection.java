package documents;

import users.*;

public interface DocumentCollection {

    void addOfficialDocument(String ID, String description, User manager);

    void addClassifiedDocument(String ID, String description, User manager);

}
