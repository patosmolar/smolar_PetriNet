package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.MCanvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddTransition_m implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        try {
            ((MCanvas) e.getSource()).getNet().addTransition(2,"",e.getX(),e.getY());
            ((MCanvas) e.getSource()).fillShapes();
            ((MCanvas) e.getSource()).repaint();

        }

        catch (ClassCastException cast){
            cast.printStackTrace();
        }
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
