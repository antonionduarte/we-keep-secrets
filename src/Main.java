import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Command constants
        public static final String EXIT = "EXIT";
        public static final String HELP = "HELP";
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

        // System out messages
        // TODO

        Scanner in = new Scanner(System.in);
        String command = "";

        while (!command.equals(EXIT)) {
            command = getCommand(in);
            processCommand(command);
        }

        in.close();
    }

    private static processCommand(Scanner in, String command) {

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
