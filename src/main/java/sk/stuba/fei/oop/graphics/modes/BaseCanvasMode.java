package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sun.nio.ch.Net;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BaseCanvasMode implements MouseListener {

    private NetCanvas canvas;

    public BaseCanvasMode(NetCanvas canvas) {
        this.canvas = canvas;
    }

    public NetCanvas getCanvas() {
        return canvas;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
