package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.buttons.BaseButton;
import sk.stuba.fei.oop.graphics.modes.AddPlace_m;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPlaceListener implements ActionListener {

    private MCanvas canvas;

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("nastav mod na PLACE");
        this.canvas=((BaseButton)e.getSource()).getCanvas();
        canvas._removeMouseListener();
        canvas._addMouseListener(new AddPlace_m());
    }
}
