package sk.stuba.fei.oop.implemented;

public class IllegalValues extends Exception {

    public IllegalValues() {
    }

    public IllegalValues(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
