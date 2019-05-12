package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.*;
import sk.stuba.fei.oop.graphics.Elements2D.Arrow;
import sk.stuba.fei.oop.graphics.Interfaces.Drawable;
import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;

import java.awt.event.MouseEvent;

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
            if(dr instanceof Arrow){
                if(betterClick(e,(Arrow)dr)){
                    return dr;
                }

            }else {
                if (dr.isClicked(e.getX(), e.getY())) {
                    return dr;
                }
            }


        }
        return null;
    }

    private boolean betterClick(MouseEvent e,Arrow edge){
        if(edge.intersects(e.getX()-7,e.getY()-7,15,15)) {

            return true;
        }else return false;
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
