package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.Place2D;
import sk.stuba.fei.oop.implemented.IllegalValues;
import sk.stuba.fei.oop.implemented.Place;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddPlace_m implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("mod pridavania placu");


        try {
            ((MCanvas) e.getSource()).setShapes(new Place2D(e.getX(), e.getY(), new Place(1, "kokot", 0, e.getX(), e.getY())));
        } catch (IllegalValues illegalValues) {
            illegalValues.printStackTrace();
        }
        ((MCanvas) e.getSource()).repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
