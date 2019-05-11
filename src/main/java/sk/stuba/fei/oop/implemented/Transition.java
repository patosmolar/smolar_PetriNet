package sk.stuba.fei.oop.implemented;

import java.util.ArrayList;

public class Transition extends BaseElement {

    private ArrayList<BaseEdge> edgess = new ArrayList<>();
    private boolean isActive;
    private int x;
    private int y;


    public Transition(long ID, String name,int x,int y) {
        super(name,ID);
        this.x = x;
        this.y = y;

    }

    public boolean isActive() {
        checkActivation();
        return isActive;
    }
    private void checkActivation(){
        try{
            valuesChecker();
            this.isActive = true;
        }catch (IllegalTransmitionActivationExceptioon e){
            this.isActive = false;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return super.getName();
    }

    public long getID() {
        return super.getID();
    }

    public void setEdgess(BaseEdge h) {
        edgess.add(h);
    }


    public void activate() throws IllegalTransmitionActivationExceptioon {
        this.valuesChecker();
        for (BaseEdge hh : edgess) {

            hh.moveTokens();
        }
    }


    public void valuesChecker() throws IllegalTransmitionActivationExceptioon {

        for (BaseEdge hh : edgess) {
            if (hh instanceof OutEdge) {
                ((OutEdge) hh).check();
            }
        }


    }

}
