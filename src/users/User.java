package users;

import documents.*;
import iterators.*;
import clearance.*;

public interface User {

    String getID();

    String getKind();

    Clearance getClearance();

    boolean hasClearance(Clearance clearance);

    boolean hasDocument(String docID);

    void upload(Document document);

    String read(Document document);

    Iterator userDocs();

}
