package sk.stuba.fei.oop.implemented;

public class Place extends BaseElement {

    private int value;
    private boolean isStatic;
    private int x;
    private int y;

    public Place(long ID, String name, int value,int x,int y) throws IllegalValues {
        super(name,ID);
        if (value < 0) throw new IllegalValues("Pocet tokenov musi byt vacsi alebo rovny 0");
        this.x = x;
        this.y = y;
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
       return super.getName();
    }

    public long getID() {
        return super.getID();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {

        this.value = value;
    }

}
