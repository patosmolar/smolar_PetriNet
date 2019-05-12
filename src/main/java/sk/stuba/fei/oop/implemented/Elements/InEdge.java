package sk.stuba.fei.oop.implemented.Elements;

import sk.stuba.fei.oop.implemented.Exceptions.IllegalValues;

public class InEdge extends Edge {


    public InEdge(Transition t, Place p, long ID, int weight) throws IllegalValues {
        super(t, p, ID, weight);
        super.t.setEdgess(this);
    }



    @Override
    public void moveTokens() {
        super.p.setValue(super.p.getValue() + super.getWeight());
    }


}
