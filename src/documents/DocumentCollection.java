package documents;

import iterators.*;
import clearance.*;
import users.*;

public interface DocumentCollection {

    /**
     * Adds a document to the collection.
     * @param document to add to the collection.
     */
    void addDocument(Document document);

    /**
     * Checks if the collection has a specific document.
     * @param docID of the Document to check.
     * @return true if there is a Document with the specified <code>docID</code>, false if otherwise.
     */
    boolean hasDocument(String docID);

    /**
     * Returns the Document object with the specified <code>docID</code>.
     * @param docID of the Document.
     * @return the Document.
     */
    Document getDocumentObject(String docID);

    /**
     * Returns an Iterator of documents.
     * @return a Document Iterator.
     */
    Iterator<Document> documentIterator();

    /**
     * Returns the clearance of the document.
     * @param documentID of the Document to get the clearance of.
     * @return the clearance of the document with the given documentID. 
     */
    Clearance getDocumentClearance(String documentID);

    /**
     * Returns the description of the document.
     * @param documentID ID of the Document to get the description of.
     * @param reader user that reads the document.
     * @return the description of the Document with the given documentID.
     */
    String getDocumentDescription(String documentID, User reader);

    /**
     * Changes the description of the document with the given documentID.
     * @param documentID of the document to change the description of.
     * @param relatedUser user that writes in the document.
     * @param description that will replace the old description.
     */
    void setDocumentDescription(String documentID,User relatedUser, String description);

    /**
     * Returns the grant count of the document with the given documentID.
     * @param documentID ID of the document.
     * @return the grantCount of the document.
     */
    int getGrantCount(String documentID);

    /**
     * Returns the revoke count of the document with the given documentID.
     * @param documentID ID of the document.
     * @return revokeCount of the document.
     */
    int getRevokeCount(String documentID);

    /**
     * Returns a specific document off the collection.
     * @return a specific document on the collection.
     */
    Document getDocument(String documentID);

    /**
     * Grants access to a document to a specific user.
     * @param documentID ID of the document to give the user access to.
     * @param relatedUser user to revoke access from the document.
     */
    void grant(String documentID, User relatedUser);

    /**
     * Revokes a document from a user.
     * @param documentID ID of the document.
     * @param relatedUser user to revoke access from the document.
     */
    void revoke(String documentID, User relatedUser);

    /**
     * Checks if a specific user has a grant to use a specific document.
     * @param documentID ID of the document to verify.
     * @param user user to verify.
     * @return true if the user has a grant to the document with the specified documentID.
     */
    boolean hasGrant(String documentID, User user);
}
