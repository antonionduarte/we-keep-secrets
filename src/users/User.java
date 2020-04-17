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
     * @return the kind of the User.
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
     * Checks if uses with <code>userID</code> has grant for document with id <code>documentID</code>.
     * @param documentID the document id.
     * @param user the user.
     * @return true if has grant, false otherwise.
     */
    boolean hasGrant(String documentID, User user);

    /**
     * Uploads a document.
     * @param document to upload.
     */
    void upload(Document document);

    /**
     * Reads content of a document.
     * @param documentID the document id.
     * @param reader user that reads from the document.
     * @return the content of the document.
     */
    String read(String documentID, User reader);

    /**
     * Returns an iterator of the User Documents.
     * @return Iterator of the User Documents.
     */
    Iterator<Document> userDocs();

    /**
     * Gets clearance from a user owned document.
     * @param documentID the id of the document.
     * @return the document clearance.
     */
    Clearance getDocumentClearance(String documentID);

    /**
     * TODO: Exclusive to officers.
     * Gets the grant count.
     * @return the grant count.
     */
    int getGrantCount();

    /**
     * TODO: Exclusive to officers. (And is this necessary?)
     * Gets the revoke count.
     * @return the revoke count.
     */
    int getRevokeCount();

    /**
     * Checks if user has an id greater than <code>otherID</code>.
     * @param otherID the id of the other user.
     * @return true if is greater, false otherwise.
     */
    boolean idGreaterThan(String otherID);

    /**
     * Returns the documentCollection of a User.
     * This method is only necessary for the class OfficerClass.
     * @return the documentCollection of the user.
     */
    DocumentCollection getUploadedDocs();

    /**
     * Returns a document with the specific documentID.
     * @param documentID of the document to return.
     * @return the document with the given documentID.
     */
    Document getDocument(String documentID); 

}
