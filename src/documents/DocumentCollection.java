package documents;

import iterators.*;
import clearance.*;
import users.*;

public interface DocumentCollection {

    /**
     * Adds a document to the colection.
     * @param document to add to the colection.
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
     * Checks if a given user is the manager of the Document.
     * @param documentID of the document to check the manager of.
     * @param user user that we will verify if is the manager of the document.
     * @return true if the user is the manager, false if otherwise.
     */
    boolean isDocumentManager(String documentID, User user);

    /**
     * Returns a specific document off the collection.
     * @return a specific document on the collection.
     */
    Document getDocument(String documentID);
}
