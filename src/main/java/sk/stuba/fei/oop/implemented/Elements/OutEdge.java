package sk.stuba.fei.oop.implemented.Elements;

import sk.stuba.fei.oop.implemented.Exceptions.IllegalTransmitionActivationExceptioon;
import sk.stuba.fei.oop.implemented.Exceptions.IllegalValues;

public class OutEdge extends Edge {

    public OutEdge(Transition t, Place p, long ID, int weight) throws IllegalValues {
        super(t, p, ID, weight);
        super.t.setEdgess(this);
    }

    @Override
    public void moveTokens() {
        super.p.setValue(super.p.getValue() - super.getWeight());
    }

    public void check() throws IllegalTransmitionActivationExceptioon {
        if (super.getWeight() > super.getP().getValue()) {
            throw new IllegalTransmitionActivationExceptioon();
        }
    }
}
