package documents;

import clearance.Clearance;
import iterators.*;
import users.*;

public class DocumentCollectionClass implements DocumentCollection {

    // Constants

    private static final int DEFAULT_SIZE = 100;
    private static final int GROWTH_FACTOR = 2;

    // Variables

    /**
     * The manager of the documents in the collection.
     */
    User manager;

    /**
     * The array of documents.
     */
    private Document[] documents;

    /**
     * The counter associated with the document array <code>documents</code>.
     */
    private int counter;

    public DocumentCollectionClass(User manager) {
        this.documents = new Document[DEFAULT_SIZE];
        this.manager = manager;
    }

    // Methods

    /**
     * Resizes the document array when it reaches the maximum length.
     */
    private void resize() {
        Document[] tempDocuments = new Document[documents.length * GROWTH_FACTOR];
        for (int i = 0; i < counter; i++)
            tempDocuments[i] = documents[i];
        documents = tempDocuments;
    }

    /**
     * Checks if the array of documents is full.
     * @return true if the array of documents is full. False if otherwise.
     */
    private boolean isFull() {
        return counter == documents.length;
    }

    /**
     * Searches for the index of a specific docID. Returns (-1) if it can't be
     * found.
     * @param documentID of the Document.
     * @return the index of the Document in the collection. Returns (-1) if the Document isn't found.
     */
    private int searchIndex(String documentID) {
        int pos = -1;
        for (int i = 0; i < counter && pos == -1; i++) {
            if (documents[i].getID().equals(documentID))
                pos = i;
        }
        return pos;
    }

    @Override
    public boolean hasDocument(String documentID) {
        return searchIndex(documentID) != -1;
    }

    @Override
    public void addDocument(Document document) {
        if (isFull())
            resize();
        documents[counter++] = document;
    }

    @Override
    public Document getDocumentObject(String documentID) {
        return documents[searchIndex(documentID)];
    }

    @Override
    public Iterator<Document> documentIterator() {
        return new IteratorClass<Document>(documents, counter);
    }

    @Override
    public Clearance getDocumentClearance(String documentID) {
        return documents[searchIndex(documentID)].getClearance();
    }

    @Override
    public String getDocumentDescription(String documentID, User reader) {
        return documents[searchIndex(documentID)].getDescription(reader);
    }

    @Override
    public void setDocumentDescription(String documentID, User relatedUser, String description) {
        documents[searchIndex(documentID)].setDescription(description, relatedUser);
    }

    @Override
    public boolean isDocumentManager(String documentID, User user) {
        return user.equals(manager);
    }

    @Override
    public Document getDocument(String documentID) {
        return documents[searchIndex(documentID)];
    }

    @Override
    public void grant(String documentID, User relatedUser) {
        ClassifiedDocument document = (ClassifiedDocument) documents[searchIndex(documentID)];
        document.grant(relatedUser);
    }

    @Override
    public void revoke(String documentID, User relatedUser) {
        ClassifiedDocument document = (ClassifiedDocument) documents[searchIndex(documentID)];
        document.revoke(relatedUser);
    }
}
