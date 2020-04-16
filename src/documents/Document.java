package documents;

import users.*;
import clearance.*;

public interface Document {

    /**
     * Sets a new description to the document.
     * @param text to set the description to.
     * @param writer user that writes in the document.
     * PRE: text != NULL
     */
    void setDescription(String text, User writer);

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
     * Gets the clearance level (int value) of the Document.
     * @return the clearance level of the Document.
     */
    Clearance getClearance();

}
