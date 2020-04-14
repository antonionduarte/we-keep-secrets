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

    /**
     * UserClass Constructor
     * @param userKind  The user kind (clerk/officer)
     * @param userID    The user unique ID
     * @param clearance the user clearance
     */
    protected UserAbstractClass(String userKind, String userID, Clearance clearance) {
        this.userKind = userKind;
        this.userID = userID;
        this.clearance = clearance;
        uploadedDocs = new DocumentCollectionClass();
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
    public void upload(Document doc) {
        uploadedDocs.addDocument(doc);
    }

    @Override
    public String read(Document document) {
        return document.getDescription();
    }

    @Override
    public Iterator<Document> userDocs() {
        return uploadedDocs.documentIterator();
    }

}
