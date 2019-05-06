package sk.stuba.fei.oop.graphics;

import java.awt.*;

public interface Drawable {
    void draw(Graphics2D g);
    boolean isClicked(double x,double y);
    void performAction();


}
