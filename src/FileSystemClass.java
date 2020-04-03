import documents.*;
import users.*;

public class FileSystemClass implements FileSystem {

    DocumentCollection dc;
    UserCollection uc;

    public FileSystemClass() {
        dc = new DocumentCollectionClass();
        uc = new UserCollectionClass();
    }
}
