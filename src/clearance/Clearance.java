package clearance;

public enum Clearance {

    // Clearance Levels
    CLERK ("official", 0),
    CONFIDENTIAL ("confidential", 1),
    SECRET ("secret", 2),
    TOPSECRET ("topsecret", 3);

    private final String clearanceString;
    private final int clearance;

    private Clearance(String clearanceString, int clearance) {
        this.clearanceString = clearanceString;
        this.clearance = clearance;
    }

    /**
     * 
     * @return the clearance level.
     */
    public int getClearance() {
        return clearance;
    }

    public String getClearanceString() {
        return clearanceString;
    }
}