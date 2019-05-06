package sk.stuba.fei.oop.implemented;

import java.util.ArrayList;

public class Transition {

    private long ID;
    private int x;
    private int y;
    private String name;
    private ArrayList<BaseEdge> edgess = new ArrayList<>();
    private boolean isActive;


    public Transition(long ID, String name,int x,int y) {
        this.ID = ID;
        this.y = y;
        this.x = x;
        this.name = name;
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

    public String getName() {
        return name;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getID() {
        return ID;
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
