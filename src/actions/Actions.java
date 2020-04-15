package actions;

public enum Actions {

	READ ("read"),
	WRITE ("write"),
	GRANT ("grant"),
	REVOKE ("revoke");

	private String actionString;

	private Actions(String actionString) {
		this.actionString = actionString;
	}

	public String getActionString() {
		return actionString;
	}
}