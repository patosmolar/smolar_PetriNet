package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sun.nio.ch.Net;

import java.awt.event.ActionEvent;
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
