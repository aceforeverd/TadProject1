package yqqs.unitconverter;

public class UnknownUnitException extends Exception {
    private String message;

    public UnknownUnitException(String msg) {
        super(msg);
        this.message = msg;
    }

    public String getMessage() {
        return "Unknown unit: " + message;
    }
}
