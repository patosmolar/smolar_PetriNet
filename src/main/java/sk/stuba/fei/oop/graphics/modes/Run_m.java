package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.Interfaces.Drawable;
import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.graphics.Elements2D.Transition2D;

import java.awt.event.MouseEvent;

public class Run_m extends BaseCanvasMode {
    public Run_m(NetCanvas canvas) {
        super(canvas);
    }

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
