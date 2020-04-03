package users;

import iterators.*;
import documents.*;
import iterators.*;

public class UserClass implements User {

    // Constants
    private static final String OFFICER_TAG = "officer";

    //Instance variables
    private String userID;
    private String userKind;
    private String clearance;

    private DocumentCollection uploadedDocs;
    private int uploadedDocsCounter;

    /**
     * UserClass Constructor
     * @param userKind  The user kind (clerk/officer)
     * @param userID    The user unique ID
     * @param clearance the user clearance
     */
    public UserClass(String userKind, String userID, String clearance) {
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

    public String getClearance() {
        return clearance;
    }

    /**
     * Checks if user is an officer
     * @return Boolean. true - is an officer ; false - is not an officer
     */
    public boolean isOfficer() {
        return userKind.equalsIgnoreCase(OFFICER_TAG);
    }

    public void upload( /* Place Params Here!!*/ ) {

    }

    public String read( /* Place Params Here!! */ ) {
        return "0";
    }

    public Iterator userDocs() {
        return new IteratorClass(uploadedDocs, uploadedDocsCounter);
    }

    public void write( /* Place Params Here!! */ ) {

    }

}
