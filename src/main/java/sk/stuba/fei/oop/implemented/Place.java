package sk.stuba.fei.oop.implemented;

public class Place {

    private int value;
    private long ID;
    private String name;
    private int x;
    private int y;
    private boolean isStatic;

    public Place(long ID, String name, int value,int x,int y) throws IllegalValues {
        if (value < 0) throw new IllegalValues("Pocet tokenov musi byt vacsi alebo rovny 0");
        this.ID = ID;
        this.x = x;
        this.y = y;
        this.name = name;
        this.value = value;
        this.isStatic = false;
    }

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public long getID() {
        return ID;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {

        this.value = value;
    }

}
