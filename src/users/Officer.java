package users;

public interface Officer extends Clerk {

    abstract void write(/* Place Params Here!! */);

    abstract void grant(/* Place Params Here!! */);

    abstract void revoke(/* Place Params Here!! */);
}
