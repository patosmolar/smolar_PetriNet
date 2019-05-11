package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.Drawable;
import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.graphics.Place2D;

import java.awt.event.MouseEvent;

public class ChangeToken_m extends BaseCanvasMode {
    public ChangeToken_m(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(getClickedDrawable(e) != null){
            if(e.getButton() == MouseEvent.BUTTON1){
                getClickedDrawable(e).performAction(1);
                super.getCanvas().repaint();
            }else if(e.getButton() == MouseEvent.BUTTON3) {

                getClickedDrawable(e).performAction(-1);
                super.getCanvas().repaint();
            }

        }


    }


    private Drawable getClickedDrawable(MouseEvent e){
        for (Drawable dr : ((MCanvas) e.getSource()).getShapes()) {
            if (dr.isClicked(e.getX(), e.getY()) && dr instanceof Place2D) {
                return dr;
            }
        }
        return null;
    }
}
