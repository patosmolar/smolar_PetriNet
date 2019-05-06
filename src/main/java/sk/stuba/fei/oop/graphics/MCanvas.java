package sk.stuba.fei.oop.graphics;

import org.w3c.dom.Document;
import sk.stuba.fei.oop.implemented.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MCanvas extends Canvas {


    private  ArrayList<Drawable> shapes = new ArrayList<>();
    private PetriNet net;

    public MCanvas() {



    }


    public void clearElements(){
        shapes.clear();
    }



    public void _addMouseListener(MouseListener mouseListener){
        this.addMouseListener(mouseListener);
    }
    public void _removeMouseListener(){
        for (MouseListener m:this.getMouseListeners()) {
            this.removeMouseListener(m);
        }
    }

    public void fillShapes(){

        for (Place p:net.getpList()) {
            setShapes(new Place2D(p.getX(),p.getY(),p));
        }

        for (Transition t:net.gettList()) {
            setShapes(new Transition2D(t.getX(),t.getY(),t));
        }

        for (BaseEdge myedge:net.getEdgesList()) {
            if(myedge instanceof InEdge){
                setShapes(new InEdge2D((InEdge)myedge));
            }
            else if(myedge instanceof  OutEdge){
                setShapes(new OutEdge2D((OutEdge)myedge));
            }
            else if(myedge instanceof  ResEdge){
                setShapes(new ResEdge2D((ResEdge)myedge));
            }
        }

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (Drawable dr: shapes) {
            dr.draw((Graphics2D)g);
        }
    }

    public void setShapes(Drawable shape){
        shapes.add(shape);
    }
    public ArrayList<Drawable> getShapes() {
        return shapes;
    }

    public PetriNet getNet() {
        return net;
    }

    public void setNet(PetriNet net) {
        this.net = net;
    }

}
