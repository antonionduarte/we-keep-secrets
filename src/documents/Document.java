package documents;

import users.*;

public interface Document {

    /**
     * Sets a new description to the document.
     * @param text to set the description to.
     * PRE: text != NULL
     */
    void setDescription(String text);

    /**
     * Shows the description of the document.
     * @return <code>description</code> of the document.
     * PRE: description != NULL
     */
    String getDescription();

    /**
     * Shows the ID of the document.
     * @return the <code>ID</code> of the document.
     * PRE ID != NULL
     */
    String getID();

    /**
     * Checks if a given user is the manager of the document.
     * @param user to compare with.
     * @return true if the given user is the manager, false if otherwise.
     */
    boolean isManager(User user);

    /**
     * Gets the clearance String of the Document.
     * @return the clearance String of the Document.
     */
    String getClearanceString();

    /**
     * Gets the clearance level (int value) of the Document.
     * @return the clearance level of the Document.
     */
    int getClearance();

}
