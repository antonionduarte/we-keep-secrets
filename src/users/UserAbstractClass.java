package users;

import iterators.*;
import documents.*;
import clearance.*;

public abstract class UserAbstractClass implements User {

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

    /**
     * Gets the id of the user.
     *
     * @return     The id.
     */
    public String getID() {
        return userID;
    }

    /**
     * Gets the user kind (clerk/officer)
     *
     * @return     The user kind
     */
    public String getKind() {
        return userKind;
    }

    /**
     * Gets the user clearance.
     *
     * @return     The user clearance.
     */
    public Clearance getClearance() {
        return clearance;
    }

    /**
     * Determines if user has clearance higher or equal to given clearance.
     *
     * @param      clearance  The clearance to compare user to
     *
     * @return     True if has clearance, False otherwise.
     */
    public boolean hasClearance(Clearance clearance) {
        return this.clearance.toInt() >= clearance.toInt();
    }

    /**
     * Determines if user has given document
     *
     * @param      docID  The document id
     *
     * @return     True if document, False otherwise.
     */
    public boolean hasDocument(String docID) {
        return uploadedDocs.hasDocument(docID);
    }

    /**
     * Uploads a document
     *
     * @param      doc   The document
     */
    public void upload(Document doc) {
        uploadedDocs.addDocument(doc);
    }

    /**
     * Read a given document
     *
     * @param      document  The document object
     *
     * @return     The document's content
     */
    public String read(Document document) {
        return document.getDescription();
    }

    /**
     * Iterates through all user uplaoded files
     *
     * @return     An iterator object
     */
    public Iterator userDocs() {
        return uploadedDocs.documentIterator();
    }

    public abstract void write(Document document, String message);

    public abstract void grant(Document document, User user);

    public abstract void revoke(Document document, User user);

}
