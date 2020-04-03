package documents;

public class DocumentCollectionClass implements DocumentCollection {

    // Constants
    private static final int DEFAULT_SIZE = 100;
    private static final int GROWTH_FACTOR = 2;

    // Variables

    /**
     * The array of documents.
     */
    private Document[] documents;

    /**
     * The counter associated with the document array <code>documents</code>.
     */
    private int counter;

    public DocumentCollectionClass() {
        this.documents = new Document[DEFAULT_SIZE];
    }

    // Methods

    private void resize() {
        Document[] tempDocuments;
    }

}
