package actions;

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