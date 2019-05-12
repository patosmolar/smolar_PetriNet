package sk.stuba.fei.oop.graphics.actionListeners;


import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.graphics.modes.AddTransition_m;
import java.awt.event.ActionEvent;

public class AddTransitionListener extends BaseListener {


    public AddTransitionListener(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("nastav mod na Transition");
        super.getCanvas()._removeMouseListener();
        super.getCanvas()._addMouseListener(new AddTransition_m(super.getCanvas()));
    }
}
