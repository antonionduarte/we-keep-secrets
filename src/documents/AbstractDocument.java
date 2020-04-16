package documents;

import actions.*;
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
     * ActionCollection that stores the grants and revokes.
     */
    private ActionCollection grantsRevokes;

    /**
     * ActionCollection that stores the reads and writes.
     */
    private ActionCollection readsWrites;

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
        grantsRevokes = new ActionCollectionClass(this);
        readsWrites = new ActionCollectionClass(this);
    }

    // Methods

    @Override
    public void setDescription(String text, User writer) {
        this.description = text;
        readsWrites.addAction(writer, Actions.WRITE);
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
