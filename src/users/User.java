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
     * Pre: clearance != NULL
     * @param clearance to check for.
     * @return true if the user has a clearance value superior or equal to clearance.
     */
    boolean hasClearance(Clearance clearance);

    /**
     * Verified if the user is the owner of a specific document.
     * Pre: docID != NULL
     * @param docID of the document to check.
     * @return true if the user is the manager of the document with the specified docID.
     */
    boolean hasDocument(String docID);

    /**
     * Uploads a document.
     * Pre: docID != NULL
     * @param document to upload.
     */
    void upload(Document document);

    /**
     * Reads content of a document.
     * Pre: documentID != NULL && reader != NULL
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
     * Pre: documentID != NULL
     * @param documentID the id of the document.
     * @return the document clearance.
     */
    Clearance getDocumentClearance(String documentID);

    /**
     * Checks if user has an id greater than <code>otherID</code>.
     * Pre: otherID != NULL
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
     * Pre: documentID != NULL
     * @param documentID of the document to return.
     * @return the document with the given documentID.
     */
    Document getDocument(String documentID);
    
    /**
     * Returns the amount of documents that the user has.
     * @return the number of documents that the user has.
     */
    int getNumberDocuments();
}
