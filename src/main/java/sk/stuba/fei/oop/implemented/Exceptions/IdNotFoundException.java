package sk.stuba.fei.oop.implemented.Exceptions;

public class IdNotFoundException extends Exception {
    public IdNotFoundException() {
    }

    public IdNotFoundException(String message) {
        super(message);
    }

    public void GetOveralMessage() {
        System.out.println("Zle zadane ID");
    }
}
