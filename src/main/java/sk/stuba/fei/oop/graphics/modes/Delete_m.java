package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Delete_m extends BaseCanvasMode {
    public Delete_m(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(getClickedDrawable(e) != null){
            super.getCanvas().getNet().removeElement(getClickedDrawable(e).getSuperId());
            getCanvas().fillShapes();
            getCanvas().repaint();
        }

    }


    private Drawable getClickedDrawable(MouseEvent e){
        for (Drawable dr : ((MCanvas) e.getSource()).getShapes()) {
            if (dr.isClicked(e.getX(), e.getY())) {
                return dr;
            }

        }
        return null;
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
