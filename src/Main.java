import java.util.Scanner;
import documents.*;
import users.*;
import clearance.*;
import actions.*;

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

    // System success out messages
    private static final String USER_SUCCESSFULLY_REGISTER  = "User %s was registered.\n";
    private static final String DOCUMENT_UPLOADED           = "Document %s was uploaded.\n";
    private static final String DOCUMENT_ÛPDATED            = "Document %s was updated.\n";

    private static final String EXIT_MESSAGE = "Bye!";

    // System error out messages
    private static final String USER_ALREADY_REGISTERED     = "Identifier %s is already assigned to another user.\n";
    private static final String USER_NOT_REGISTERED         = "User %s is not a registered user.\n";
    private static final String NOT_A_REGISTERED_USER       = "Not a registered user.";
    private static final String USER_HAS_DOCUMENT           = "Document %s already exists in the user account.\n";
    private static final String USER_DOESNT_HAVE_DOCUMENT   = "Document %s does not exist in the user account.\n"
    private static final String NO_USER_REGISTERED          = "There are no registered users.";
    private static final String NOT_ENOUGH_CLEARANCE        = "Insufficient security clearance.";
    private static final String CANNOT_UPDATE               = "Document %s cannot be updated.\n";

    
    public static void main(String[] args) {

        // Initiate Scanner
        Scanner in = new Scanner(System.in);

        // Initiate FileSystem
        FileSystem fs = FileSystemClass();

        // Other instance variables
        String command = "";

        // Main loop
        while (!command.equals(EXIT)) {
            command = getCommand(in);
            processCommand(in, fs, command);
        }

        // Close Scanner and terminate (I'll be back)
        in.close();
    }

    private static void processCommand(Scanner in, FileSystem fs, String command) {
        switch (command) {
            case REGISTER:
                processRegister(in, fs);
                break;
            case LISTUSERS:
                processListUsers(in, fs);
                break;
            case UPLOAD:
                processUpload(in, fs);
                break;
            case WRITE:
                processWrite(in, fs);
                break;
            case READ:
                processRead(in, fs);
                break;
            case GRANT:
                processGrant(in, fs);
                break;
            case REVOKE:
                processRevoke(in, fs);
                break;
            case USERDOCS:
                processUserDocs(in, fs);
                break;
            case TOPLEAKED:
                processTopLeaked(in, fs);
                break;
            case TOPGRANTERS:
                processTopGranters(in, fs);
                break;
            case EXIT:
                System.out.println(EXIT_MESSAGE);
                break;
            case HELP:
                processHelp();
                break;
        }
    }

    private static void processRegister(Scanner in, FileSystem fs) {
        String userKind = in.next();
        String userID = in.next();
        String clearance = in.nextLine();

        if (fs.userExists())
            Clearance c = searchClearance(clearance);
            fs.register(userKind, userID, c);
            System.out.printf(USER_SUCCESSFULLY_REGISTER, userID);
        else
            System.out.println(USER_ALREADY_REGISTERED, userID);
    }

    private static void processListUsers(Scanner in, FileSystem fs) {
        Iterator iter = fs.listUsers();
        if (iter.hasNext()) {
            while (iter.hasNext()) {
                User u = iter.next();
                System.out.printf("%s %s %s\n", u.getKind(), u.getID(), u.getClearance().getClearanceString())
            }
        } else {
            System.out.println(NO_USER_REGISTERED);
        }
    }

    private static void processUpload(Scanner in, FileSystem fs) {
        String docName = in.next();
        String managerID = in.next();
        String securityLevel = in.nextLine();
        String description = in.nextLine();

        Clearance c = searchClearance(securityLevel);

        if (fs.userExists()) {
            if (fs.userHasDocument(managerID, docName)) {
                System.out.printf(USER_HAS_DOCUMENT, docName);
            } else {
                if (managerID.getClearance.toInt() >= c.toInt()) {
                    fs.upload(docName, managerID, c, description);
                    System.out.printf(DOCUMENT_UPLOADED, docName);
                } else {
                    System.out.printf(NOT_ENOUGH_CLEARANCE);
                }
            }
        } else {
            System.out.printf(USER_NOT_REGISTERED, managerID);
        }
    }

    private static void processWrite(Scanner in, FileSystem fs) {
        String docName = in.next()
        String managerID = in.next();
        String userID = in.nextLine();
        String description = in.nextLine();

        if (fs.userExists(managerID) && fs.userExists(userID)) {
            if (fs.userHasDocument(managerID, docName)) {
                if (fs.isOfficial(docName)) {
                    System.out.printf(CANNOT_UPDATE, docName);
                } else {
                    if ( (fs.getUserClearance(userID).toInt() >= fs.getUserClearance().toInt()) || fs.hasGrant(userID, docName) )
                        fs.write(docName, managerID, userID, description);
                        System.out.println(DOCUMENT_ÛPDATED, docName);
                }
            } else {
                System.out.printf(USER_DOESNT_HAVE_DOCUMENT, docName);
            }
        } else {
            System.out.println(NOT_A_REGISTERED_USER);
        }
    }

    private static void processRead(Scanner in, FileSystem fs) {
        
    }

    private static void processGrant(Scanner in, FileSystem fs) {
        
    }
    private static void processUserDocs(Scanner in, FileSystem fs) {
        
    }

    private static void processTopLeaked(Scanner in, FileSystem fs) {
        
    }

    private static void processTopGranters(Scanner in, FileSystem fs) {
        
    }

    private static void processHelp() {
        for (HelpMenu h: HelpMenu.values())
            System.out.println(h.message());
    }




    private static String getCommand(Scanner in) {
        return in.nextLine().toUpperCase();
    }
}
