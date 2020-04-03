import java.util.Scanner;

public class Main {

    // Command constants
    private static final String EXIT = "EXIT";
    private static final String HELP = "HELP";
    private static final String REGISTER = "REGISTER";
    private static final String LISTUSERS = "LISTUSERS";
    private static final String UPLOAD = "UPLOAD";
    private static final String WRITE = "WRITE";
    private static final String READ = "READ";
    private static final String GRANT = "GRANT";
    private static final String REVOKE = "REVOKE";
    private static final String USERDOCS = "USERDOCS";
    private static final String TOPLEAKED = "TOPLEAKED";
    private static final String TOPGRANTERS = "TOPGRANTERS";

    // Message constants 
    // TODO: Fix EXIT_MESSAGE, I added this placeholder because the error
    // was annoying me.
    private static final String EXIT_MESSAGE = "PLACEHOLDER";
    public static void main(String[] args) {
        // System out messages
        // TODO
        Scanner scanner = new Scanner(System.in);
        String command = "";

        while (!command.equals(EXIT)) {
            command = getCommand(scanner);
            processCommand(command);
        }

        scanner.close();
    }

    private static void processCommand(String command) {

        switch (command) {

            case EXIT: {
                System.out.println(EXIT_MESSAGE);
                break;
            }
            case HELP: {
                processHelp();
                break;
            }
        }
    }

    private static void processHelp() {
        // TODO
    }




    private static String getCommand(Scanner in) {
        return in.nextLine().toUpperCase();
    }
}
