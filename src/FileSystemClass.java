import documents.*;
import users.*;
import iterators.*;

public class FileSystemClass implements FileSystem {

    DocumentCollection dc;
    UserCollection uc;

    public FileSystemClass() {
        dc = new DocumentCollectionClass();
        uc = new UserCollectionClass();
    }
}
