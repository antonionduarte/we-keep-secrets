package users;

import iterators.*;
import documents.*;
import clearance.*;

public abstract class UserAbstractClass implements User {

    //Instance variables
    private String userID;
    private String userKind;
    private Clearance clearance;

    private DocumentCollection uploadedDocs;

    private int grantCount;
    private int revokeCount;

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
        uploadedDocs = new DocumentCollectionClass(this); // Assigns this user as the manager of the DocumentCollection.
        grantCount = 0;
        revokeCount = 0;
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
    public boolean hasClearance(Clearance clearance) {
        return this.clearance.toInt() >= clearance.toInt();
    }

    @Override
    public boolean hasDocument(String docID) {
        return uploadedDocs.hasDocument(docID);
    }

    @Override
    public boolean hasGrant(String documentID, User user) {
        return uploadedDocs.hasGrant(documentID, user);
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
    public int getGrantCount() {
        return grantCount;
    }

    @Override
    public int getRevokeCount() {
        return revokeCount;
    }

    @Override
    public boolean idGreaterThan(String otherID) {
        return this.getID().compareTo(otherID) > 0;
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
