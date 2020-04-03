package users;

public interface Clerk {

    abstract String getID();

    abstract String getKind();

    abstract String getClearance();

    abstract boolean isOfficer();

    abstract void upload( /* Place Params Here!! */ );

    abstract String read(/* Place Params Here!! */);

    abstract Iterator userDocs();
}
