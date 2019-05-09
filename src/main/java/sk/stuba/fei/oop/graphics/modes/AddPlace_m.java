package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.NetCanvas;

import java.awt.event.MouseEvent;

public class AddPlace_m extends BaseCanvasMode {
    public AddPlace_m(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        super.getCanvas().getNet().addPlace(super.getCanvas().getIdGenerator().getNewId(),"",0,e.getX(),e.getY());
        super.getCanvas().fillShapes();
        super.getCanvas().repaint();

    }


}
