package documents;

import clearance.*;
import users.*;

public abstract class AbstractDocument implements Document {

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
     * Clearance level of the document.
     */
    private Clearance clearance;

    /**
     * The constructor of the document.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param manager is the user that created the document.
     */
    protected AbstractDocument(String ID, String description, User manager, Clearance clearance) {
        this.ID = ID;
        this.description = description;
        this.manager = manager;
        this.clearance = clearance;
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

    @Override
    public boolean isManager(User user) {
        return user.equals(manager);
    }

    @Override
    public Clearance getClearance() {
        return clearance;
    }
}
