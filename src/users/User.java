package users;

import documents.*;
import iterators.*;
import clearance.*;

public interface User {

    abstract String getID();

    abstract String getKind();

    abstract Clearance getClearance();

    abstract boolean hasClearance(Clearance clearance);

    abstract boolean hasDocument(String docID);

    abstract void upload(Document document);

    abstract String read(Document document);

    abstract Iterator userDocs();

}
