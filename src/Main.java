import java.util.Scanner;
import documents.*;
import users.*;
import iterators.*;
import clearance.*;
import actions.*;
import sys.*;

public class Main {

    // Generic constants
    public static final int MAX_ACCESSES_SHOWN = 10;

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
    private static final String DOCUMENT_UPDATED            = "Document %s was updated.\n";

    private static final String UNKNOWN_COMMAND				= "Unknown command. Type help to see available commands.";
    private static final String EXIT_MESSAGE                = "Bye!";

    // System error out messages
    private static final String USER_ALREADY_REGISTERED     = "Identifier %s is already assigned to another user.\n";
    private static final String USER_NOT_REGISTERED         = "User %s is not a registered user.\n";
    private static final String NOT_A_REGISTERED_USER       = "Not a registered user.";
    private static final String USER_HAS_DOCUMENT           = "Document %s already exists in the user account.\n";
    private static final String USER_DOESNT_HAVE_DOCUMENT   = "Document %s does not exist in the user account.\n";
    private static final String NO_USER_REGISTERED          = "There are no registered users.";
    private static final String NOT_ENOUGH_CLEARANCE        = "Insufficient security clearance.";
    private static final String INNAPROPRIATE_CLEARANCE     = "Innapropriate security level.";
    private static final String CANNOT_UPDATE               = "Document %s cannot be updated.\n";
    private static final String NO_ACCESSES                 = "There are no accesses.";
    private static final String NO_GRANTS                   = "There are no grants.";
    private static final String NO_DOCUMENT_FOR_CLEARANCE   = "There are no %s documents.\n";
    private static final String GRANTS_FOR_OFFICERS         = "Grants can only be issued between officers.";
    private static final String USER_ALREADY_HAS_ACCESS     = "Already has access to document %s.\n";
    private static final String GRANT_DOES_NOT_EXIST        = "Grant for officer %s does not exist.\n";
    private static final String ALREADY_BEEN_REVOKED        = "Grant for officer %s was already revoked.\n";

    public static void main(String[] args) {

        // Initiate Scanner
        Scanner in = new Scanner(System.in);

        // Initiate FileSystem
        FileSystem fs = new FileSystemClass();

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
            default:
            	System.out.println(UNKNOWN_COMMAND);
        }
    }

    private static void processRegister(Scanner in, FileSystem fs) {
    	Clearance c = Clearance.CLERK;
    	
        String userKind = in.next().toLowerCase();
        String userID = in.next();
        String clearance = in.nextLine().trim().toLowerCase();
        
        if (!userKind.equals(c.getClearanceString()))
        	c = searchClearance(clearance);

        if (fs.hasUser(userID)) {
        	System.out.printf(USER_ALREADY_REGISTERED, userID);
            
        } else {
        	fs.register(userKind, userID, c);
        	System.out.printf(USER_SUCCESSFULLY_REGISTER, userID);
        }
    }

    private static void processListUsers(Scanner in, FileSystem fs) {
        Iterator<User> iter = fs.listUsers();
        if (iter.hasNext()) {
            while (iter.hasNext()) {
                User u = iter.next();
                System.out.printf("%s %s %s\n", u.getKind(), u.getID(), u.getClearance().getClearanceString());
            }
        } else
            System.out.println(NO_USER_REGISTERED);
    }

    private static void processUpload(Scanner in, FileSystem fs) {
        String documentID = in.next();
        String managerID = in.next();
        String securityLevel = in.nextLine().trim();
        String description = in.nextLine();
        Clearance c = searchClearance(securityLevel);
        if (fs.hasUser(managerID)) {
            if (fs.userHasDocument(managerID, documentID))
                System.out.printf(USER_HAS_DOCUMENT, documentID);
            else {
                if (fs.getUserClearance(managerID).toInt() >= c.toInt()) {
                    fs.upload(documentID, managerID, description, c);
                    System.out.printf(DOCUMENT_UPLOADED, documentID);
                } else
                    System.out.println(NOT_ENOUGH_CLEARANCE);
            }
        } else
            System.out.printf(USER_NOT_REGISTERED, managerID);
    }

    private static void processWrite(Scanner in, FileSystem fs) {
        String documentID = in.next();
        String managerID = in.next();
        String userID = in.nextLine().trim();
        String description = in.nextLine();

        if (fs.hasUser(managerID) && fs.hasUser(userID)) {
            if (fs.userHasDocument(managerID, documentID)) {
                if (fs.isOfficial(managerID, documentID))
                    System.out.printf(CANNOT_UPDATE, documentID);
                else {
                    if ( (fs.getUserClearance(userID).toInt() >= fs.getUserClearance(managerID).toInt()) || fs.hasGrant(managerID, userID, documentID) )
                        fs.write(documentID, managerID, userID, description);
                        System.out.printf(DOCUMENT_UPDATED, documentID);
                }
            } else 
                System.out.printf(USER_DOESNT_HAVE_DOCUMENT, documentID);
        } else
            System.out.println(NOT_A_REGISTERED_USER);
    }

    private static void processRead(Scanner in, FileSystem fs) {
        String documentID = in.next();
        String managerID = in.next();
        String userID = in.nextLine().trim();
        if (fs.hasUser(managerID) && fs.hasUser(userID)) {
            if (fs.userHasDocument(managerID, documentID))
                System.out.println(fs.read(managerID, userID, documentID));
            else
                System.out.printf(USER_DOESNT_HAVE_DOCUMENT, documentID);
        } else
            System.out.println(NOT_A_REGISTERED_USER);
    }

    private static void processGrant(Scanner in, FileSystem fs) {
        String documentID = in.next();
        String managerID = in.next();
        String userID = in.nextLine().trim();
        if (fs.hasUser(managerID) && fs.hasUser(userID)) {
            if (!fs.getUserClearance(userID).equals(Clearance.CLERK) && !fs.getUserClearance(managerID).equals(Clearance.CLERK)) {
                if (fs.userHasDocument(managerID, documentID)) {
                    if ((fs.getDocumentClearance(managerID, documentID).toInt() > fs.getUserClearance(userID).toInt()) || fs.hasGrant(managerID, userID, documentID))
                        fs.grant(userID, documentID, managerID);
                    else
                        System.out.printf(USER_ALREADY_HAS_ACCESS, documentID);
                } else
                    System.out.printf(USER_DOESNT_HAVE_DOCUMENT, documentID);
            } else
                System.out.println(GRANTS_FOR_OFFICERS);
        } else
            System.out.println(NOT_A_REGISTERED_USER);
    }

    private static void processRevoke(Scanner in, FileSystem fs) {
        String documentID = in.next();
        String managerID = in.next();
        String userID = in.nextLine().trim();
        if (fs.hasUser(managerID) && fs.hasUser(userID)) {
            if (!fs.getUserClearance(userID).equals(Clearance.CLERK) && !fs.getUserClearance(managerID).equals(Clearance.CLERK)) {
                if (fs.userHasDocument(managerID, documentID)) {
                    if (fs.hasGrant(managerID, userID, documentID)) {
                        if (fs.isRevoked(managerID, userID, documentID))
                            fs.revoke(userID, documentID, managerID);
                        else
                            System.out.printf(ALREADY_BEEN_REVOKED, userID);
                    } else
                        System.out.printf(GRANT_DOES_NOT_EXIST, userID);
                } else
                    System.out.printf(USER_DOESNT_HAVE_DOCUMENT, documentID);
            } else
                System.out.println(GRANTS_FOR_OFFICERS);
        } else
            System.out.println(NOT_A_REGISTERED_USER);
    }

    private static void processUserDocs(Scanner in, FileSystem fs) { // this works
        String userID = in.next().trim();
        String clearance = in.nextLine().trim();
        Clearance c = searchClearance(clearance);

        int accessCounter = 0;

        if (fs.hasUser(userID)) {
            if (fs.getUserClearance(userID).toInt() >= c.toInt()) {

                Iterator<Document> iter = fs.userDocs(userID, c);

                if (iter.hasNext()) {
                    while (iter.hasNext()) {
                        Document doc = iter.next();
                        Iterator<Action> readWriteIterator = doc.documentReadsWritesIterator();
                        if (c.toInt() == Clearance.OFFICIAL.toInt()) {
                            System.out.printf("%s %s: ", doc.getID(), readWriteIterator.itemCount());
                            if (readWriteIterator.hasNext()) {
                                Action act = readWriteIterator.next();
                                User user = act.getRelatedUser();
                                Actions actionType = act.getActionType();
                                System.out.printf("%s [%s]", user.getID(), actionType.getActionString());
                                accessCounter++;

                                while (readWriteIterator.hasNext() && accessCounter < MAX_ACCESSES_SHOWN) {
                                    act = readWriteIterator.next();
                                    user = act.getRelatedUser();
                                    actionType = act.getActionType();
                                    System.out.printf(", %s [%s]", user.getID(), actionType.getActionString());
                                    accessCounter++;

                                }
                                System.out.println();
                            } else
                                System.out.println(NO_ACCESSES);
                        } else
                            System.out.println(doc.getClearance());
                            // TODO: Implement userdocs for classified option
                    }
                } else
                    System.out.printf(NO_DOCUMENT_FOR_CLEARANCE, clearance);
            } else
                System.out.println(INNAPROPRIATE_CLEARANCE);
        } else
            System.out.println(NOT_A_REGISTERED_USER);
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

    private static Clearance searchClearance(String temp) {
        Clearance aux = Clearance.CLERK;
        for (Clearance c: Clearance.values()) {
            if (c.getClearanceString().equals(temp))
                aux = c;
        }
        return aux;
    }
}
