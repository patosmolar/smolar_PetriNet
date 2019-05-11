package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.Place2D;
import sk.stuba.fei.oop.implemented.EdgeAlreadyExistsException;

import java.awt.event.MouseEvent;


public class AddResEdge_m extends BaseCanvasMode {
    private Drawable first = null;
    private Drawable second = null;


    public AddResEdge_m(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (first == null) {
            setFirst(e);
        }
        else if (second == null) {
            setSecond(e);

            try {
                super.getCanvas().getNet().edgeAlreadyExist(first, second);
                first.unHighlight();
                super.getCanvas().getNet().addResEdge(first.getSuperId(),second.getSuperId(),super.getCanvas().getIdGenerator().getNewId());
                first = null;
                second = null;
                super.getCanvas().fillShapes();
                super.getCanvas().repaint();

            } catch (EdgeAlreadyExistsException ee) {

                }
        }




        }


    private void setFirst(MouseEvent e) {
        for (Drawable dr : ((MCanvas) e.getSource()).getShapes()) {
            if (dr.isClicked(e.getX(), e.getY()) && dr instanceof Place2D) {
                this.first = dr;
                first.highlight();
                super.getCanvas().repaint();
                System.out.println("prvy nastavenny");
                break;
            }
        }
    }

    private void setSecond(MouseEvent e) {

        for (Drawable dr : ((MCanvas) e.getSource()).getShapes()) {
            if (dr.isClicked(e.getX(), e.getY())) {
                this.second = dr;
                System.out.println("druhy nastavenny");
                break;
            }
        }
    }
}


