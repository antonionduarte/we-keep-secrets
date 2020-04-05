import documents.*;
import users.*;
import iterators.*;
import clearance.*;

public class FileSystemClass implements FileSystem {

    DocumentCollection dc;
    UserCollection uc;

    public FileSystemClass() {
        dc = new DocumentCollectionClass();
        uc = new UserCollectionClass();
    }
}
