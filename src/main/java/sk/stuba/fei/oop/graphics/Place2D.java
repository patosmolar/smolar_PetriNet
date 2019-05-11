package sk.stuba.fei.oop.graphics;


import sk.stuba.fei.oop.implemented.IllegalTokenChangeException;
import sk.stuba.fei.oop.implemented.IllegalTransmitionActivationExceptioon;
import sk.stuba.fei.oop.implemented.Place;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.lang.String;

public class Place2D extends Ellipse2D.Float implements Drawable {
    private Place place;
    private boolean highlighted;

    public Place2D(int x, int y, Place place) {
        super(x, y, 50, 50);
        this.place = place;
    }



    @Override
    public void draw(Graphics2D g) {

        g.drawString(""+place.getValue(),(int) getCenterX(),(int)getCenterY());
        g.drawString(""+place.getName(),(int)getCenterX(),(int)getCenterY()-30);
        if(highlighted){
            g.setPaint(Color.BLUE);
        }else{
            g.setPaint(Color.BLACK);
        }
        g.draw(this);
        g.setPaint(Color.BLACK);
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
    public void performAction(int var) {
        try {
            checker(var);
            place.setValue(place.getValue()+var);
        } catch (IllegalTokenChangeException ae) {

        }

    }

    @Override
    public long getSuperId() {
       return place.getID();
    }

    @Override
    public void highlight() {
        this.highlighted = true;
    }

    @Override
    public void unHighlight() {
        this.highlighted = false;
    }



    private void checker(int var) throws IllegalTokenChangeException {
        if(place.getValue()+var < 0 ){
            throw new IllegalTokenChangeException();
        }

    }



}


