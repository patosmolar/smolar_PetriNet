package sk.stuba.fei.oop.graphics;


import sk.stuba.fei.oop.implemented.Place;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.lang.String;

public class Place2D extends Ellipse2D.Float implements Drawable {
    private Place place;

    public Place2D(int x, int y, Place place) {
        super(x, y, 50, 50);
        this.place = place;
    }



    @Override
    public void draw(Graphics2D g) {
        g.drawString(""+place.getValue(),(int) getCenterX(),(int)getCenterY());
        g.drawString(""+place.getName(),(int)getCenterX(),(int)getCenterY()-30);
        g.draw(this);
    }

    @Override
    public boolean isClicked(double x, double y) {
        if(this.contains(x,y)){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public void performAction() {

    }

    @Override
    public long getSuperId() {
       return place.getID();
    }


}


