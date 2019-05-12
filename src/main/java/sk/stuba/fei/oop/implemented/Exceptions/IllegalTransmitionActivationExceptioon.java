package sk.stuba.fei.oop.implemented.Exceptions;

public class IllegalTransmitionActivationExceptioon extends Exception {

    public IllegalTransmitionActivationExceptioon() {
    }

    public IllegalTransmitionActivationExceptioon(String message) {
        super(message);
    }

    public void GetOveralMessage(long ID) {
        System.out.println("Transition (ID:" + ID + ") nie je spustitelny");
    }
}
