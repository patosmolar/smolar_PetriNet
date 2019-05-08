package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.implemented.IdAlreadyExists;
import sk.stuba.fei.oop.implemented.PetriNet;

import java.awt.*;
import java.awt.event.MouseListener;

public interface NetCanvas {

    void clearElements();
    void _addMouseListener(MouseListener mouseListener);
    void _removeMouseListener();
    void fillShapes();
    void setShapes(Drawable shape);
    void setNet(PetriNet net);
    void repaint();
    PetriNet getNet();
    boolean idChecker(long ID);
    IdGenerator getIdGenerator();
}
