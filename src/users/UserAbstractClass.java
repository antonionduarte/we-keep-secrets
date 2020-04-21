package users;

import iterators.*;
import documents.*;
import clearance.*;

public abstract class UserAbstractClass implements User {

    //Instance variables

    /**
     * The ID of the user.
     */
    private String userID;

    /**
     * The kind of the user. (Officer or Clerk)
     */
    private String userKind;

    /**
     * The clearance of the user.
     */
    private Clearance clearance;

    /**
     * The collection of documents of the user.
     */
    private DocumentCollection uploadedDocs;

    /**
     * UserClass Constructor
     * @param userKind the user kind (clerk/officer).
     * @param userID the user unique ID.
     * @param clearance the user clearance.
     */
    protected UserAbstractClass(String userKind, String userID, Clearance clearance) {
        this.userKind = userKind;
        this.userID = userID;
        this.clearance = clearance;
        uploadedDocs = new DocumentCollectionClass(); // Assigns this user as the manager of the DocumentCollection.
    }

    @Override
    public String getID() {
        return userID;
    }

    @Override
    public String getKind() {
        return userKind;
    }

    @Override
    public Clearance getClearance() {
        return clearance;
    }

    @Override
    public int getNumberDocuments() {
        return uploadedDocs.getNumberDocuments();
    }

    @Override
    public boolean hasDocument(String docID) {
        return uploadedDocs.hasDocument(docID);
    }

    @Override
    public void upload(Document document) {
        uploadedDocs.addDocument(document);
    }

    @Override
    public String read(String documentID, User reader) {
        return uploadedDocs.getDocumentDescription(documentID, reader);
    }

    @Override
    public Iterator<Document> userDocs() {
        return uploadedDocs.documentIterator();
    }

    public Clearance getDocumentClearance(String documentID) {
        return uploadedDocs.getDocumentClearance(documentID);
    }

    @Override
    public DocumentCollection getUploadedDocs() {
        return uploadedDocs;
    }

    @Override
    public Document getDocument(String documentID) {
        return uploadedDocs.getDocument(documentID);
    }
}
