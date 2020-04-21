package documents;

import iterators.*;
import clearance.*;
import users.*;
import actions.*;

public interface DocumentCollection {

    /**
     * Adds a document to the collection.
     * Pre: document != NULL
     * @param document to add to the collection.
     */
    void addDocument(Document document);

    /**
     * Insert a document in the collection sorting by grant count.
     * Pre: document != NULL
     * @param document to insert in the collection.
     */
    void insertSort(Document document);

    /**
     * Checks if the collection has a specific document.
     * Pre: docID != NULL
     * @param docID of the Document to check.
     * @return true if there is a Document with the specified <code>docID</code>, false if otherwise.
     */
    boolean hasDocument(String docID);

    /**
     * Returns the number of documents in the collection.
     * @return the number of the documents in the collection.
     */
    int getNumberDocuments();

    /**
     * Returns an Iterator of documents.
     * @return a Document Iterator.
     */
    Iterator<Document> documentIterator();

    /**
     * Returns an Iterator of document actions.
     * Pre: documentID != NULL
     * @param documentID the document id.
     * @return a Document Iterator.
     */
    Iterator<Action> documentReadsWritesIterator(String documentID);

    /**
     * Returns the clearance of the document.
     * Pre: documentID != NULL
     * @param documentID of the Document to get the clearance of.
     * @return the clearance of the document with the given documentID.
     */
    Clearance getDocumentClearance(String documentID);

    /**
     * Returns the description of the document.
     * Pre: documentID != NULL && reader != NULL
     * @param documentID ID of the Document to get the description of.
     * @param reader user that reads the document.
     * @return the description of the Document with the given documentID.
     */
    String getDocumentDescription(String documentID, User reader);

    /**
     * Returns the grant count of the document with the given documentID.
     * Pre: documentID != NULL
     * @param documentID ID of the document.
     * @return the grantCount of the document.
     */
    int getGrantCount(String documentID);

    /**
     * Returns the revoke count of the document with the given documentID.
     * Pre: documentID != NULL
     * @param documentID ID of the document.
     * @return revokeCount of the document.
     */
    int getRevokeCount(String documentID);

    /**
     * Returns a specific document off the collection.
     * Pre: documentID != NULL
     * @return a specific document on the collection.
     */
    Document getDocument(String documentID);

    /**
     * Grants access to a document to a specific user.
     * Pre documentID != NULL && relatedUser != NULL
     * @param documentID ID of the document to give the user access to.
     * @param relatedUser user to revoke access from the document.
     */
    void grant(String documentID, User relatedUser);

    /**
     * Revokes a document from a user.
     * Pre: documentID != NULL && relatedUser != NULL
     * @param documentID ID of the document.
     * @param relatedUser user to revoke access from the document.
     */
    void revoke(String documentID, User relatedUser);

    /**
     * Checks if a specific user has a grant to use a specific document.
     * Pre: documentID != NULL && user != NULL
     * @param documentID ID of the document to verify.
     * @param user user to verify.
     * @return true if the user has a grant to the document with the specified documentID.
     */
    boolean hasGrant(String documentID, User user);

    /**
     * Checks if a specific user is revoked from a document.
     * Pre: documentID != NULL && user != NULL
     * @param documentID ID of the document to verify.
     * @param user user to verify.
     * @return true if the user is currently revoked from the document, false if otherwise.
     */
    boolean isRevoked(String documentID, User user);

    /**
     * Trims the collection to have a specified trimSize.
     * Pre: trimSize != NULL
     * @param trimSize size that we will trim the collection to have.
     */
    void trim(int trimSize);
}
