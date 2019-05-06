package sk.stuba.fei.oop.graphics.buttons;

import sk.stuba.fei.oop.graphics.MCanvas;

import java.awt.*;
import java.awt.event.ActionListener;


public class AddPlaceBtn extends BaseButton {


    public AddPlaceBtn(String label, MCanvas canvas) throws HeadlessException {
        super(label, canvas);
    }

    @Override
    public synchronized void addActionListener(ActionListener l) {
        super.addActionListener(l);

    }
}
