package documents;

import users.*;
import clearance.*;
import iterators.*;
import actions.*;

public interface Document {

    /**
     * Sets a new description to the document.
     * @param text to set the description to.
     * @param writer user that writes in the document.
     * PRE: text != NULL
     */
    void setDescription(String text, User writer);

    /**
     * Returns the ID of the document's manager.
     * @return returns the userID of the document's manager.
     */
    String getManagerID();

    /**
     * Shows the description of the document.
     * @param reader user that reads from the document.
     * @return <code>description</code> of the document.
     * PRE: description != NULL
     */
    String getDescription(User reader);

    /**
     * Returns the number of accesses to the document.
     * @return the numberAccesses of the document.
     */
    int getNumberAccesses();

    /**
     * Shows the ID of the document.
     * @return the <code>ID</code> of the document.
     * PRE ID != NULL
     */
    String getID();

    /**
     * Gets the clearance level (int value) of the Document.
     * @return the clearance level of the Document.
     */
    Clearance getClearance();

    /**
     * Returns read and write action's iterator.
     * @return an action iterator.
     */
    Iterator<Action> documentReadsWritesIterator();

}
