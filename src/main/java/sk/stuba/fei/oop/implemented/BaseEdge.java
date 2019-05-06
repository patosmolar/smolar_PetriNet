package sk.stuba.fei.oop.implemented;

public abstract class BaseEdge {

    protected long ID;
    protected Transition t;
    protected Place p;

    public BaseEdge(Transition t, Place p, long ID) {
        this.ID = ID;
        this.t = t;
        this.p = p;
    }


    public Place getP() {
        return p;
    }

    public Transition getT() {
        return t;
    }

    public long getID() {
        return ID;
    }

    public abstract void moveTokens() throws IllegalTransmitionActivationExceptioon;

}
