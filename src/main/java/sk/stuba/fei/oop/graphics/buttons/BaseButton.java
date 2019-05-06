package sk.stuba.fei.oop.graphics.buttons;

import sk.stuba.fei.oop.graphics.MCanvas;

import java.awt.*;

public abstract class BaseButton extends Button {

    private MCanvas canvas;

    public BaseButton(String label, MCanvas canvas) throws HeadlessException {
        super(label);
        this.canvas = canvas;
    }

    public MCanvas getCanvas() {
        return canvas;
    }

}
