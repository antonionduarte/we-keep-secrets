package documents;

import users.*;

public abstract class DocumentAbstractClass implements Document {

    // Constants

    // Variables

    /**
     * The description (one can even say content) of the document.
     */
    private String description;

    /**
     * The identifier of the document.
     */
    private String ID;

    /**
     * The manager of the document (user who created it).
     */
    private User manager;

    /**
     * 
     */
    private String clearance;

    /**
     * The clearance level of the Document.
     * TODO: Finish this comment.
     * 1 - 
     * 2 - 
     * 3 -
     * 4 - 
     */
    private int clearanceLevel;

    /**
     * The constructor of the document.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    protected DocumentAbstractClass(String ID, String description, User manager) {
        this.ID = ID;
        this.description = description;
        this.manager = manager;
    }

    // Methods

    @Override
    public void setDescription(String text) {
        this.description = text;
    }

    @Override
    public String getDescription() {
        return this.description;
    }

    @Override
    public String getID() {
        return ID;
    }
}
