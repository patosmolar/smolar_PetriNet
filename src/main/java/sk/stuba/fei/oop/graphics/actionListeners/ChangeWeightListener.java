package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.graphics.modes.ChangeWeight_m;

import java.awt.event.ActionEvent;

public class ChangeWeightListener extends BaseListener {
    public ChangeWeightListener(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("changeweight mod");
        super.getCanvas()._removeMouseListener();
        super.getCanvas()._addMouseListener(new ChangeWeight_m(super.getCanvas()));
    }
}
