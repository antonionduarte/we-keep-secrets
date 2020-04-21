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
     * The array of documents.
     */
    private Document[] documents;

    /**
     * The counter associated with the document array <code>documents</code>.
     */
    private int documentCounter;

    public DocumentCollectionClass() {
        this.documents = new Document[DEFAULT_SIZE];
    }

    // Methods

    /**
     * Resize the document array when it reaches the maximum length.
     */
    private void resize() {
        Document[] tempDocuments = new Document[documents.length * GROWTH_FACTOR];
        for (int i = 0; i < documentCounter; i++)
            tempDocuments[i] = documents[i];
        documents = tempDocuments;
    }

    /**
     * Checks if the array of documents is full.
     * @return true if the array of documents is full. False if otherwise.
     */
    private boolean isFull() {
        return documentCounter == documents.length;
    }

    /**
     * Searches for the index of a specific docID. Returns (-1) if it can't be
     * found.
     * @param documentID of the Document.
     * @return the index of the Document in the collection. Returns (-1) if the Document isn't found.
     */
    private int searchIndex(String documentID) {
        int pos = -1;
        for (int i = 0; i < documentCounter && pos == -1; i++) {
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
        if (isFull()) resize();
        documents[documentCounter++] = document;
    }

    @Override
    public Iterator<Document> documentIterator() {
        return new IteratorClass<Document>(documents, documentCounter);
    }

    @Override
    public int getNumberDocuments() {
        return documentCounter;
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
    public int getGrantCount(String documentID) {
        ClassifiedDocument document = (ClassifiedDocument) documents[searchIndex(documentID)];
        return document.getGrantCount();
    }

    @Override
    public int getRevokeCount(String documentID) {
        ClassifiedDocument document = (ClassifiedDocument) documents[searchIndex(documentID)];
        return document.getRevokeCount();
    }

    @Override
    public Document getDocument(String documentID) {
        return documents[searchIndex(documentID)];
    }

    @Override
    public void grant(String documentID, User relatedUser) {
        Document document = documents[searchIndex(documentID)];
        if (document instanceof ClassifiedDocument)
            ((ClassifiedDocument) document).grant(relatedUser);
    }

    @Override
    public void revoke(String documentID, User relatedUser) {
        Document document = documents[searchIndex(documentID)];
        if (document instanceof ClassifiedDocument)
            ((ClassifiedDocument) document).revoke(relatedUser);
    }

    @Override
    public boolean hasGrant(String documentID, User user) {
        boolean hasGrant = false;
        Document document = documents[searchIndex(documentID)];
        if (document instanceof ClassifiedDocument)
            hasGrant = ((ClassifiedDocument) document).hasGrant(user);
        return hasGrant;
    }

    @Override
    public boolean isRevoked(String documentID, User user) {
        boolean isRevoked = false;
        Document document = documents[searchIndex(documentID)];
        if (document instanceof ClassifiedDocument)
            isRevoked = ((ClassifiedDocument) document).isRevoked(user);
        return isRevoked;
    }

    @Override
    public void insertSort(Document document) {
        if (isFull()) resize();
        int pos = -1;
        for (int i = 0; i < documentCounter && pos == -1; i++)
            if (((ClassifiedDocument) document).getGrantCount() > ((ClassifiedDocument) documents[i]).getGrantCount())
               pos = i;
            else if (((ClassifiedDocument) document).getGrantCount() == (((ClassifiedDocument) documents[i]).getGrantCount())) {
                if (documents[i].getID().compareToIgnoreCase(document.getID()) > 0)
                    pos = i;
            }
        if (pos == -1) pos = documentCounter;
        insertAt(document, pos);
    }

    @Override
    public void trim(int trimSize) {
        Document[] aux = new Document[trimSize];
        for (int i = 0; (i < trimSize) && (i < documentCounter); i++)
            aux[i] = documents[i];
        documents = aux;
        if (documentCounter > trimSize)
            documentCounter = trimSize;
    }

    /**
     * Inserts a document in a specific position in the array.
     * @param document to insert on the array.
     * @param pos position to insert on.
     */
    private void insertAt(Document document, int pos) {
        for (int i = documentCounter - 1; i >= pos; i--)
            documents[i + 1] = documents[i];
        documents[pos] = document;
        documentCounter++;
    }
}
