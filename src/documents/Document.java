package documents;

public interface Document {

    /**
     * Sets a new description to the document.
     * @param text to set the description to.
     * PRE: text != NULL
     */
    void setDescription(String text);

    /**
     * Shows the description of the document.
     * @return <code>description</code> of the document.
     * PRE: description != NULL
     */
    String getDescription();

    /**
     * Shows the ID of the document.
     * @return the <code>ID</code> of the document.
     * PRE ID != NULL
     */
    String getID();

}
