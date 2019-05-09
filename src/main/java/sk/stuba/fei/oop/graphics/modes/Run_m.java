package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.Transition2D;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Run_m implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if(run(e)){
            ((MCanvas) e.getSource()).repaint();
        }

    }


    private boolean run(MouseEvent e){
        for (Drawable dr:((MCanvas) e.getSource()).getShapes()) {
            if(dr.isClicked(e.getX(),e.getY())){
                if(dr instanceof Transition2D) {
                    dr.performAction();
                    return true;
                }
            }

        }
        return false;
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
