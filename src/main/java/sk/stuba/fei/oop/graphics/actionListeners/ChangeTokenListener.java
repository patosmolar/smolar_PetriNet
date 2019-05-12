package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.graphics.modes.ChangeToken_m;

import java.awt.event.ActionEvent;

public class ChangeTokenListener extends BaseListener {
    public ChangeTokenListener(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("addToken mod");
        super.getCanvas()._removeMouseListener();
        super.getCanvas()._addMouseListener(new ChangeToken_m(super.getCanvas()));
    }
}
