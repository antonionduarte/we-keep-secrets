package documents;

import users.*;

public interface DocumentCollection {

    /**
     * Adds an official document to the collection.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    void addOfficialDocument(String ID, String description, User manager);

    /**
     * Adds a classified document to the collection.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    void addClassifiedDocument(String ID, String description, User manager);

}
