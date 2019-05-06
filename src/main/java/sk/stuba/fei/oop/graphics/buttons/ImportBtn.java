package sk.stuba.fei.oop.graphics.buttons;

import java.awt.*;
import java.awt.event.ActionListener;

public class ImportBtn extends Button {

    public ImportBtn(String label) throws HeadlessException {
        super(label);
    }

    @Override
    public synchronized void addActionListener(ActionListener l) {
        super.addActionListener(l);
    }
}
