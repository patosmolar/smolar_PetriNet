package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.implemented.IllegalTransmitionActivationExceptioon;
import sk.stuba.fei.oop.implemented.Transition;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class Transition2D extends Rectangle2D.Float implements Drawable {

    protected Transition transition;


    public Transition2D(float x, float y, Transition transition) {
        super(x, y, 50, 50);
        this.transition = transition;
    }




    @Override
    public void draw(Graphics2D g) {

        g.setPaint(Color.BLACK);
        g.drawString(""+transition.getName(),(int)getCenterX()-30,(int)getCenterY()+40);
        g.draw(this);

        if (transition.isActive()) {
            g.setPaint(Color.GREEN);
            g.fill(this);

        }
        g.setPaint(Color.BLACK);
    }




    public boolean isClicked(double x,double y){
        if(contains(x,y)){
            return true;
        }else return false;
    }

    @Override
    public void performAction() {

        try{
            transition.activate();


        }catch (IllegalTransmitionActivationExceptioon e){

        }

    }

    @Override
    public long getSuperId() {
        return transition.getID();
    }

}
