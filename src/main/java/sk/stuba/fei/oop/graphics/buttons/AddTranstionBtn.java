package sk.stuba.fei.oop.graphics.buttons;

import sk.stuba.fei.oop.graphics.MCanvas;

import java.awt.*;
import java.awt.event.ActionListener;

public class AddTranstionBtn extends Button {

    public AddTranstionBtn(String label) throws HeadlessException {
        super(label);
    }

    @Override
    public synchronized void addActionListener(ActionListener l) {
        super.addActionListener(l);
    }
}
