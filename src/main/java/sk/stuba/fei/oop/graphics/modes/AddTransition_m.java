package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;

import java.awt.event.MouseEvent;

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
