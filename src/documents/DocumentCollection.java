package documents;

import iterators.*;

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
    Iterator documentIterator();
}
