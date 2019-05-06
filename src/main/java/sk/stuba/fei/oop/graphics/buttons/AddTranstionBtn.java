package sk.stuba.fei.oop.graphics.buttons;

import sk.stuba.fei.oop.graphics.MCanvas;

import java.awt.*;
import java.awt.event.ActionListener;

public class AddTranstionBtn extends BaseButton {

    public AddTranstionBtn(String label, MCanvas canvas) throws HeadlessException {
        super(label, canvas);
    }

    @Override
    public synchronized void addActionListener(ActionListener l) {
        super.addActionListener(l);
    }
}
