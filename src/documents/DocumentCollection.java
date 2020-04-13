package documents;

import iterators.*;

public interface DocumentCollection {

    /**
     * Adds a document to the colection.
     * @param document to add to the colection.
     */
    void addDocument(Document document);

    boolean hasDocument(String docID);

    Document getDocumentObject(String docID);

    Iterator documentIterator();
}
