package sk.stuba.fei.oop.implemented;

public class IdAlreadyExists extends Exception {
    public IdAlreadyExists() {
    }

    public IdAlreadyExists(long ID) {
    }

    public IdAlreadyExists(String message) {
        super(message);
    }

    public void GetOveralMessage(long ID) {
        System.out.println("Zadana id " + ID + " uz existuje");
    }

}
