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
    private int uploadedDocsCounter;

    /**
     * UserClass Constructor
     * @param userKind  The user kind (clerk/officer)
     * @param userID    The user unique ID
     * @param clearance the user clearance
     */
    protected UserClass(String userKind, String userID, int clearance) {
        this.userKind = userKind;
        this.userID = userID;
        this.clearance = clearance;
        uploadedDocs = new DocumentCollectionClass();
        uploadedDocsCounter = 0;
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

    /**
     * Checks if user is an officer
     * @return Boolean. true - is an officer ; false - is not an officer
     */
    public boolean isOfficer() {
        return getClearance() > Clearance.CLERK.getClearance();
    }

    public void upload( /* Place Params Here!!*/ ) {

    }

    public String read( /* Place Params Here!! */ ) {
        return "0";
    }

    // TODO
    // public Iterator userDocs() {
    //     return new IteratorClass(uploadedDocs, uploadedDocsCounter);
    // }

    public abstract void write( /* Place Params Here!! */ );

    public abstract void grant( /* Place Params Here!! */);

    public abstract void revoke(/* Place Params Here!! */);

}
