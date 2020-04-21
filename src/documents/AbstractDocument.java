package documents;

import actions.*;
import clearance.*;
import users.*;
import iterators.*;

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
     * Number of accesses to a document (both reads and writes).
     */
    private int numberAccesses;

    /**
     * Manager of the document.
     */
    private User manager;

    /**
     * The constructor of the document.
     * Pre: ID != NULL && description != NULL && clearance != NULL
     * @param ID that identifies the document.
     * @param description or content that the document has.
     * @param clearance access level of the document.
     */
    protected AbstractDocument(String ID, String description, Clearance clearance, User manager) {
        this.ID = ID;
        this.manager = manager;
        this.description = description;
        this.clearance = clearance;
        readsWrites = new ActionCollectionClass();
    }

    // Methods

    @Override
    public void setDescription(String text, User writer) {
        this.description = text;
        readsWrites.addAction(writer, Actions.WRITE);
        numberAccesses++;
    }

    @Override
    public String getManagerID() {
        return manager.getID();
    }

    @Override
    public String getDescription(User reader) {
        readsWrites.addAction(reader, Actions.READ);
        numberAccesses++;
        return this.description;
    }

    @Override
    public int getNumberAccesses() {
        return numberAccesses;
    }

    @Override
    public String getID() {
        return ID;
    }

    @Override
    public Clearance getClearance() {
        return clearance;
    }

    @Override
    public Iterator<Action> documentReadsWritesIterator() {
        return readsWrites.actionIterator();
    }
}
