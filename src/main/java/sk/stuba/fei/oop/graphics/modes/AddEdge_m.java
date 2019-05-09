package sk.stuba.fei.oop.graphics.modes;

import sk.stuba.fei.oop.graphics.*;
import sk.stuba.fei.oop.implemented.*;

import java.awt.event.MouseEvent;


public class AddEdge_m extends BaseCanvasMode {
    private Drawable first= null;
    private Drawable second = null;


    public AddEdge_m(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(first == null){
            for (Drawable dr:((MCanvas) e.getSource()).getShapes()) {
                if(dr.isClicked(e.getX(),e.getY())){
                    this.first = dr;
                    System.out.println("prvy nastavenny");
                    break;
                }
            }
        }
        else if(second == null){
            for (Drawable dr:((MCanvas) e.getSource()).getShapes()) {
                if(dr.isClicked(e.getX(),e.getY())){
                    if(!comparator(first,dr)){
                        System.out.println("druhy nastaveny");
                        this.second = dr;
                        if(edgeAlreadyExist(first,second)){
                            first = null;
                            second = null;
                            System.out.println("rovnaky");
                        }
                        else if(first instanceof Place2D){
                            super.getCanvas().getNet().addOutEdge(first.getSuperId(),second.getSuperId(),super.getCanvas().getIdGenerator().getNewId(),1);
                            first = null;
                            second = null;
                        }else{
                            super.getCanvas().getNet().addInEdge(first.getSuperId(),second.getSuperId(),super.getCanvas().getIdGenerator().getNewId(),1);
                            first = null;
                            second = null;
                        }

                        break;
                    }

                }

            }
            first = null;


        }


        super.getCanvas().fillShapes();
        super.getCanvas().repaint();
    }


    private boolean comparator(Drawable dr1,Drawable dr2){
        if(dr1 instanceof Place2D && dr2 instanceof Place2D){
            return true;
        }
        else if(dr1 instanceof Transition2D && dr2 instanceof Transition2D){
            return true;
        }
        else{
            return false;
        }
    }

    private boolean edgeAlreadyExist(Drawable dr1,Drawable dr2){
        for (BaseEdge edge:super.getCanvas().getNet().getEdgesList()) {
            if(dr1 instanceof Place2D && edge instanceof OutEdge){
                if(dr1.getSuperId() == edge.getP().getID() && dr2.getSuperId() == edge.getT().getID()){
                    return true;
                }
            }else if(dr1 instanceof Transition2D && edge instanceof InEdge){
                if(dr1.getSuperId() == edge.getT().getID() && dr2.getSuperId() == edge.getP().getID()){
                    return true;
                }
            }

        }
        return false;
    }
}
