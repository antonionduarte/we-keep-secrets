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
     * Clearance level of the document.
     */
    private Clearance clearance;

    /**
     * ActionCollection that stores the reads and writes.
     */
    private ActionCollection readsWrites;

    /**
     * The constructor of the document.
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param clearance access level of the document.
     */
    protected AbstractDocument(String ID, String description, Clearance clearance) {
        this.ID = ID;
        this.description = description;
        this.clearance = clearance;
        readsWrites = new ActionCollectionClass(this);
    }

    // Methods

    @Override
    public void setDescription(String text, User writer) {
        this.description = text;
        readsWrites.addAction(writer, Actions.WRITE);
    }

    @Override
    public String getDescription(User reader) {
        readsWrites.addAction(reader, Actions.READ);
        return this.description;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public Clearance getClearance() {
        return clearance;
    }
}
