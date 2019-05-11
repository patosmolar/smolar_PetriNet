package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.modes.Delete_m;
import sk.stuba.fei.oop.graphics.modes.Run_m;

import java.awt.event.ActionEvent;

public class DeleteListener extends BaseListener {


    public DeleteListener(MCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Delete MODE");
        super.getCanvas()._removeMouseListener();
        super.getCanvas()._addMouseListener(new Delete_m(super.getCanvas()));

    }

}
