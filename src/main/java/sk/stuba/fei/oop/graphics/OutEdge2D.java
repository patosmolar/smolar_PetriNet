package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.implemented.OutEdge;

import java.awt.*;

public class OutEdge2D extends Arrow implements Drawable {

    private OutEdge edge;

    public OutEdge2D(OutEdge edge) {
        super(edge.getP().getX(),edge.getP().getY(),edge.getT().getX(),edge.getT().getY());
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
}
