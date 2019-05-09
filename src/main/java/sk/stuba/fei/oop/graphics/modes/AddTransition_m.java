package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.NetCanvas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddTransition_m extends BaseCanvasMode {
    public AddTransition_m(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.getCanvas().getNet().addTransition(super.getCanvas().getIdGenerator().getNewId(),"",e.getX(),e.getY());
        super.getCanvas().fillShapes();
        super.getCanvas().repaint();
    }

}
