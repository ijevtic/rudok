package rudok.model.error;

public class ErrorClass {
    private String message;
    private ErrorType type;
    private String icon;
    public ErrorClass(String message, String icon, ErrorType errorType) {
        this.message = message;
        this.type = errorType;
        this.icon = icon;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorType getType() {
        return type;
    }

    public void setType(ErrorType type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
