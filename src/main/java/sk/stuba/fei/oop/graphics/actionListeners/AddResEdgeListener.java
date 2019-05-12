package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.graphics.modes.AddResEdge_m;

import java.awt.event.ActionEvent;

public class AddResEdgeListener extends BaseListener {
    public AddResEdgeListener(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("Resedge mod");
        super.getCanvas()._removeMouseListener();
        super.getCanvas()._addMouseListener(new AddResEdge_m(super.getCanvas()));
    }
}
