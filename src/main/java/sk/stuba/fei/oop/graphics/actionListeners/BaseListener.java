package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;

import java.awt.event.ActionListener;

public abstract class BaseListener implements ActionListener {

    private NetCanvas canvas;

    public BaseListener(NetCanvas canvas) {
        this.canvas = canvas;
    }

    public NetCanvas getCanvas() {
        return canvas;
    }

    public void setCanvas(MCanvas canvas) {
        this.canvas = canvas;
    }
}
