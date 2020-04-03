package users;

import iterators.*;
import documents.*;

public abstract class UserAbstractClass implements User {

    // Constants
    private static final String OFFICER_TAG = "officer";

    //Instance variables
    private String userID;
    private String userKind;
    private int clearance;

    private DocumentCollection uploadedDocs;

    /**
     * UserClass Constructor
     * @param userKind  The user kind (clerk/officer)
     * @param userID    The user unique ID
     * @param clearance the user clearance
     */
    protected UserAbstractClass(String userKind, String userID, int clearance) {
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

    public int getClearance() {
        return clearance;
    }

    public boolean hasClearance(String clearance) {
        return this.clearance >= clearance;
    }

    public void upload(Document doc) {
        uploadedDocs.addDocument(doc);
    }

    public String read( /* Place Params Here!! */ ) {
        return "READ: TO BE IMPLEMENTED!";
    }

    // TODO
    // public Iterator userDocs() {
    //     return new IteratorClass(uploadedDocs, uploadedDocsCounter);
    // }

    public abstract void write( /* Place Params Here!! */ );

    public abstract void grant( /* Place Params Here!! */);

    public abstract void revoke(/* Place Params Here!! */);

}
