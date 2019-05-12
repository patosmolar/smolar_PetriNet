package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.*;
import sk.stuba.fei.oop.graphics.Elements2D.Arrow;
import sk.stuba.fei.oop.graphics.Interfaces.Drawable;
import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;

import java.awt.event.MouseEvent;

public class ChangeWeight_m extends BaseCanvasMode {
    public ChangeWeight_m(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if(getClickedDrawable(e) != null){
                if(e.getButton() == MouseEvent.BUTTON1){
                    getClickedDrawable(e).performAction(1);
                }
                else if(e.getButton() == MouseEvent.BUTTON3){
                    getClickedDrawable(e).performAction(-1);
                }
         super.getCanvas().repaint();
        }



    }


    private Drawable getClickedDrawable(MouseEvent e){
        for (Drawable dr : ((MCanvas) e.getSource()).getShapes()) {
            if(dr instanceof Arrow){
                if(betterClick(e,(Arrow)dr)){
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
}
