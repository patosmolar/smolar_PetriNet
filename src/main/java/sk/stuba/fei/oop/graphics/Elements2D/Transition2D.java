package sk.stuba.fei.oop.graphics.Elements2D;

import sk.stuba.fei.oop.graphics.Interfaces.Drawable;
import sk.stuba.fei.oop.implemented.Exceptions.IllegalTransmitionActivationExceptioon;
import sk.stuba.fei.oop.implemented.Elements.Transition;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Transition2D extends Rectangle2D.Float implements Drawable {

    protected Transition transition;
    private boolean running;
    private boolean highlighted;


    public Transition2D(float x, float y, Transition transition) {
        super(x, y, 50, 50);
        this.transition = transition;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    @Override
    public void draw(Graphics2D g) {

        if(highlighted){
            g.setPaint(Color.BLUE);
        }else{
            g.setPaint(Color.BLACK);
        }

        g.drawString(""+transition.getName(),(int)getCenterX()-30,(int)getCenterY()+40);
        g.draw(this);

        if (transition.isActive() && running) {
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
    public void performAction(int var) {

    }

    @Override
    public long getSuperId() {
        return transition.getID();
    }


    @Override
    public void highlight() {
        this.highlighted = true;
    }

    @Override
    public void unHighlight() {
        this.highlighted = false;
    }


}
