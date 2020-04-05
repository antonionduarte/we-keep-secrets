package users;

import documents.*;
import iterators.*;
import clearance.*;

public interface User {

    abstract String getID();

    abstract String getKind();

    abstract int getClearance();

    abstract boolean hasClearance(Clearance clearance);

    abstract void upload(Document document);

    abstract String read(Document document);

    abstract Iterator userDocs();

}
