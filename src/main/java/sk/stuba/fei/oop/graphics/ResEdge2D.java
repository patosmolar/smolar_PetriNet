package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.implemented.ResEdge;

import java.awt.*;

public class ResEdge2D extends Arrow implements Drawable {

    private ResEdge edge;
    public ResEdge2D(ResEdge edge) {
        super(edge.getP().getX(),edge.getP().getY(),edge.getT().getX(),edge.getT().getY());
        this.edge = edge;
    }

    @Override
    public void draw(Graphics2D g) {
        this.drawArrow(g);
        g.drawString("RESET-EDGE",(int)this.getCenterX(),(int)this.getCenterY());


    }

    @Override
    public boolean isClicked(double x, double y) {
        return false;
    }

    @Override
    public void performAction() {

    }
}