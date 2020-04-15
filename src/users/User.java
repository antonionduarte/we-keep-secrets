package users;

import documents.*;
import iterators.*;
import clearance.*;

public interface User {

    /**
     * Returns the ID of the User.
     * @return the ID of the User.
     */
    String getID();

    /**
     * Returns the kind of the User (Officer or Clerk).
     * @return
     */
    String getKind();

    /**
     * Returns the Clearance of the User.
     * @return the Clearance of the User.
     */
    Clearance getClearance();

    /**
     * Checks if the User has a specific Clearance.
     * @param clearance to check for.
     * @return true if the user has a clearance value superior or equal to clearance.
     */
    boolean hasClearance(Clearance clearance);

    /**
     * Verified if the user is the owner of a specific document.
     * @param docID of the document to check.
     * @return true if the user is the manager of the document with the specified docID.
     */
    boolean hasDocument(String docID);

    /**
     * Uploads a document.
     * @param document to upload.
     */
    void upload(Document document);

    /**
     * Reads content of a document
     *
     * @param      documentID  The document id
     *
     * @return     The content of the document
     */
    String read(String documentID);

    /**
     * Returns an iterator of the User Documents.
     * @return Iterator of the User Documents.
     */
    Iterator<Document> userDocs();

    /**
     * Gets clearance from a user owned document
     *
     * @param      documentID  The document id
     *
     * @return     The document clearance.
     */
    Clearance getDocumentClearance(String documentID);

    /**
     * Gets the grant count.
     *
     * @return     The grant count.
     */
    int getGrantCount();

    /**
     * Gets the revoke count.
     *
     * @return     The revoke count.
     */
    int getRevokeCount();

    /**
     * Gets the document number the user owns.
     *
     * @return     The document number.
     */
    int getDocumentNumber();

    /**
     * Checks if user has an id greater than <code>otherID</code>.
     *
     * @param      otherID  The other id
     *
     * @return     True if is greater, False otherwise
     */
    boolean idGreaterThan(String otherID);

}
