package actions;

/**
 * This enum describes all available actions in the filesystem
 * @author Antonio Duarte 58278
 * @author Luis Tripa 57882
 */
public enum Actions {

	READ ("read"),
	WRITE ("write"),
	GRANT ("grant"),
	REVOKE ("revoked");

	private String actionString;

	Actions(String actionString) {
		this.actionString = actionString;
	}

	public String getActionString() {
		return actionString;
	}
}