package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.modes.Run_m;

import java.awt.event.ActionEvent;

public class RunListener extends BaseListener {


    public RunListener(MCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("RUN MODE");
        super.getCanvas()._removeMouseListener();
        super.getCanvas()._addMouseListener(new Run_m(getCanvas()));
        super.getCanvas().turnActive();

    }

}
