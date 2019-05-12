package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.graphics.modes.AddPlace_m;

import java.awt.event.ActionEvent;

public class AddPlaceListener extends BaseListener {

    public AddPlaceListener(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("nastav mod na PLACE");
        super.getCanvas()._removeMouseListener();
        super.getCanvas()._addMouseListener(new AddPlace_m(super.getCanvas()));
    }
}
