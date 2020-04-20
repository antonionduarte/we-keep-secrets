public enum HelpMenu {

    // Command list for the help menu
    REGISTER ("register - registers a new user"),
    LISTUSERS ("listusers - list all registered users"),
    UPLOAD ("upload - upload a document"),
    READ ("read - read a document"),
    WRITE ("write - write a document"),
    GRANT ("grant - grant access a document"),
    REVOKE ("revoke - revoke a grant to access a document"),
    USERDOCS ("userdocs - list the official or classified documents of an user"),
    TOPLEAKED ("topleaked - list the top 10 documents with more grants"),
    TOPGRANTERS ("topgranters - list the top 10 officers that have given more grants"),
    HELP ("help - shows the available commands"),
    EXIT ("exit - terminates the execution of the program");

    private final String message;

    HelpMenu(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
