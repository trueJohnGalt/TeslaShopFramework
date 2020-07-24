package tesla.automation.info;

public enum SearchErrorMessage {

    NO_RESULTS_FOUND("No Results Found"),
    ENTER_MORE_CHARACTERS("Please enter 3 or more characters");

    private final String message;

    public String getMessage() {
        return message;
    }

    SearchErrorMessage(String message) {
        this.message = message;
    }
}
