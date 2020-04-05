package users;

import iterators.*;
import documents.*;

public abstract class UserAbstractClass implements User, HighPrevillegeUser {

    // Constants
    private static final String OFFICER_TAG = "officer";

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

    public String getID() {
        return userID;
    }

    public String getKind() {
        return userKind;
    }

    public Clearance getClearance() {
        return clearance;
    }

    public boolean hasClearance(Clearance clearance) {
        return this.clearance.getClearance() >= clearance.getClearance();
    }

    public void upload(Document doc) {
        uploadedDocs.addDocument(doc);
    }

    public String read(Document document) {
        return document.getMessage();
    }

    public Iterator userDocs() {
        return new IteratorClass(uploadedDocs, uploadedDocsCounter);
    }

    public abstract void write(Document document, String message);

    public abstract void grant(Document document, User user);

    public abstract void revoke(Document document, User user);

}
