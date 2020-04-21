package clearance;

/**
 * This enum describes all clearance levels available in the filesystem. The enum is extensible meaning that you can add or modify any of the clearance levels to fit your objective.
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public enum Clearance {

    // Tags. These are not used as clearance levels. They are only used to help identify documents as OFFICIAL or CLASSIFIED
    OFFICIAL ("official", 0),
    CLASSIFIED ("classified", 1),

    // Clearance Levels
    CLERK ("official", 0),
    CONFIDENTIAL ("confidential", 1),
    SECRET ("secret", 2),
    TOPSECRET ("topsecret", 3);

    private final String clearanceString;
    private final int clearance;

    Clearance(String clearanceString, int clearance) {
        this.clearanceString = clearanceString;
        this.clearance = clearance;
    }

    /**
     * 
     * @return the clearance level in int format.
     */
    public int toInt() {
        return clearance;
    }

    /**
     *
     * @return the clearance level in string format
     */
    public String getClearanceString() {
        return clearanceString;
    }
}
