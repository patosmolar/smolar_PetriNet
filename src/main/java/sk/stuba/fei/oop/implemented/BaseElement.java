package sk.stuba.fei.oop.implemented;

public abstract class BaseElement {
    private String name;
    private long ID;

    public BaseElement(String name, long ID) {
        this.name = name;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public long getID() {
        return ID;
    }



    public void setName(String name) {
        this.name = name;
    }

    public void setID(long ID) {
        this.ID = ID;
    }


}
