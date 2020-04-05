import java.util.Scanner;
import documents.*;
import users.*;
import clearance.*;

public class Main {

    // Command constants
    public static final String REGISTER     = "REGISTER";
    public static final String LISTUSERS    = "LISTUSERS";
    public static final String UPLOAD       = "UPLOAD";
    public static final String WRITE        = "WRITE";
    public static final String READ         = "READ";
    public static final String GRANT        = "GRANT";
    public static final String REVOKE       = "REVOKE";
    public static final String USERDOCS     = "USERDOCS";
    public static final String TOPLEAKED    = "TOPLEAKED";
    public static final String TOPGRANTERS  = "TOPGRANTERS";
    public static final String HELP         = "HELP";
    public static final String EXIT         = "EXIT";

    // System out messages
    private static final String EXIT_MESSAGE = "Bye!";

    
    public static void main(String[] args) {

        // Initiate Scanner
        Scanner in = new Scanner(System.in);

        // Other instance variables
        String command = "";

        // Main loop
        while (!command.equals(EXIT)) {
            command = getCommand(in);
            processCommand(in, command);
        }

        // Close Scanner and terminate (I'll be back)
        in.close();
    }

    private static void processCommand(Scanner in, String command) {
        switch (command) {
            case REGISTER:
                // TODO processRegister(in);
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

    private static void processRegister(Scanner in) {
        // TODO
    }

    private static void processHelp() {
        for (HelpMenu h: HelpMenu.values())
            System.out.println(h.message());
    }

    private static String getCommand(Scanner in) {
        return in.nextLine().toUpperCase();
    }
}
