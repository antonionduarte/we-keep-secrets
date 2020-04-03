package users;

import documents.*;
import iterators.*;

public interface User {

    abstract String getId();

    abstract String getKind();

    abstract int getClearance();

    abstract boolean isOfficer(); // This is probably not necessary

    abstract void upload( /* Place Params Here!! */ );

    abstract String read( /* Place Params Here!! */); // Not sure if this is necessary inside user

    abstract void write( /* Place Params Here!! */ );

    abstract void grant( /* Place Params Here!! */ );

    abstract void revoke( /* Place Params Here!! */ );

    abstract Iterator userDocs();

}
