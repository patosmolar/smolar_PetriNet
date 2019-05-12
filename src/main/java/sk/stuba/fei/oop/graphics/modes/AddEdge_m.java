package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.*;
import sk.stuba.fei.oop.graphics.Elements2D.Place2D;
import sk.stuba.fei.oop.graphics.Interfaces.Drawable;
import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.implemented.Exceptions.EdgeAlreadyExistsException;

import java.awt.event.MouseEvent;


public class AddEdge_m extends BaseCanvasMode {
    private Drawable first = null;
    private Drawable second = null;


    public AddEdge_m(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (first == null) {
            setFirst(e);
        }
        else if (second == null) {
            setSecond(e);
        }
        if(first != null && second!= null){
            try {
                super.getCanvas().getNet().edgeAlreadyExist(first, second);
                first.unHighlight();

                if (first instanceof Place2D) {
                    super.getCanvas().getNet().addOutEdge(first.getSuperId(), second.getSuperId(), super.getCanvas().getIdGenerator().getNewId(), 1);
                    first = null;
                    second = null;
                } else {
                    super.getCanvas().getNet().addInEdge(first.getSuperId(), second.getSuperId(), super.getCanvas().getIdGenerator().getNewId(), 1);
                    first = null;
                    second = null;
                }


                super.getCanvas().fillShapes();
                super.getCanvas().repaint();

            } catch (EdgeAlreadyExistsException ee) {

                }
        }




    }


    private void setFirst(MouseEvent e) {
        for (Drawable dr : ((MCanvas) e.getSource()).getShapes()) {
            if (dr.isClicked(e.getX(), e.getY())) {
                this.first = dr;
                super.getCanvas().repaint();
                first.highlight();
                System.out.println("prvy nastaveny");
                return;
            }
        }
        this.first = null;
        this.second = null;


    }

    private void setSecond(MouseEvent e)  {

        for (Drawable dr : ((MCanvas) e.getSource()).getShapes()) {
            if (dr.isClicked(e.getX(), e.getY())) {
                this.second = dr;
                System.out.println("druhy nastaveny");
                return;
            }
        }

        this.first = null;
        this.second = null;

    }
}


