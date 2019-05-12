package sk.stuba.fei.oop.graphics.Elements2D;

import sk.stuba.fei.oop.graphics.Interfaces.Drawable;
import sk.stuba.fei.oop.implemented.Exceptions.IllegalValues;
import sk.stuba.fei.oop.implemented.Elements.InEdge;

import java.awt.*;

public class InEdge2D extends Arrow implements Drawable {

    private boolean highlighted;
    private InEdge edge;
    public InEdge2D(InEdge edge) {
        super(edge.getT().getX(),edge.getT().getY(),edge.getP().getX(),edge.getP().getY());
        this.edge = edge;
    }

    @Override
    public void draw(Graphics2D g) {
        this.drawArrow(g);
        g.drawString(""+edge.getWeight(),(int)this.getCenterX(),(int)this.getCenterY());
    }

    @Override
    public boolean isClicked(double x, double y) {
        return false;
    }

    @Override
    public void performAction() {

    }

    @Override
    public void performAction(int var) {
        try {
            edge.setWeight(edge.getWeight()+var);
        } catch (IllegalValues illegalValues) {

        }
    }

    @Override
    public long getSuperId() {
       return edge.getID();
    }

    @Override
    public void highlight() {
        this.highlighted = true;
    }

    @Override
    public void unHighlight() {
        this.highlighted = false;
    }


}
