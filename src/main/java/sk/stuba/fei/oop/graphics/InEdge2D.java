package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.implemented.InEdge;

import java.awt.*;

public class InEdge2D extends Arrow implements Drawable {

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
    public long getSuperId() {
       return edge.getID();
    }


}
