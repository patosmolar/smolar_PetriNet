package sk.stuba.fei.oop.implemented.Elements;

import sk.stuba.fei.oop.implemented.Exceptions.IllegalTransmitionActivationExceptioon;

public abstract class BaseEdge extends BaseElement {

    protected long ID;
    protected Transition t;
    protected Place p;

    public BaseEdge(Transition t, Place p, long ID) {
        super("",ID);
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
        return super.getID();
    }

    public abstract void moveTokens() throws IllegalTransmitionActivationExceptioon;

}
