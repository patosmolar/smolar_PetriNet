package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.graphics.modes.AddEdge_m;

import java.awt.event.ActionEvent;

public class AddEdgeListener extends BaseListener {
    public AddEdgeListener(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("edge mod");
        super.getCanvas()._removeMouseListener();
        super.getCanvas()._addMouseListener(new AddEdge_m(super.getCanvas()));
    }
}
