package sk.stuba.fei.oop.implemented.Elements;

public class ResEdge extends BaseEdge {

    public ResEdge(Transition p, Place m, long ID) {
        super(p, m, ID);
        super.t.setEdgess(this);
    }

    @Override
    public void moveTokens() {
        super.p.setValue(0);
    }
}
