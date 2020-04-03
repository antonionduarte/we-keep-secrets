import java.util.Scanner;
import documents.*;
import users.*;

public class Main {

    // Command constants
    public static final String REGISTER = "REGISTER";
    public static final String LISTUSERS = "LISTUSERS";
    public static final String UPLOAD = "UPLOAD";
    public static final String WRITE = "WRITE";
    public static final String READ = "READ";
    public static final String GRANT = "GRANT";
    public static final String REVOKE = "REVOKE";
    public static final String USERDOCS = "USERDOCS";
    public static final String TOPLEAKED = "TOPLEAKED";
    public static final String TOPGRANTERS = "TOPGRANTERS";
    public static final String HELP = "HELP";
    public static final String EXIT = "EXIT";

    // System out messages
    private static final String EXIT_MESSAGE = "Bye!";
    // TODO

    public static void main(String[] args) {

        // Initiate Scanner
        Scanner in = new Scanner(System.in);

        // Initiate DocumentCollection and UserCollection
        DocumentCollection dc = new DocumentCollectionClass();
        UserCollection uc = new UserCollectionClass();

        // Other instance variables
        String command = "";

        // Main loop
        while (!command.equals(EXIT)) {
            command = getCommand(in);
            processCommand(in, uc, dc, command);
        }

        // Close Scanner and terminate (I'll be back)
        in.close();
    }

    private static processCommand(Scanner in, UserCollection uc, DocumentCollection dc, String command) {

        switch (command) {
            case REGISTER:
                processRegister(in, uc, dc);
                break;
            // TODO: Add the other commands
            case EXIT:
                System.out.println(EXIT_MESSAGE);
                break;
            case HELP:
                processHelp();
                break;
        }
    }

    private static void processRegister(Scanner in, UserCollection uc, DocumentCollection dc) {
        // TODO
    }

    private static void processHelp() {
        for(HelpMenu h: HelpMenu.values())
            System.out.println(h.message());
    }

    private static String getCommand(Scanner in) {
        return in.nextLine().toUpperCase();
    }
}