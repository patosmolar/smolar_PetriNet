package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.graphics.Elements2D.*;
import sk.stuba.fei.oop.graphics.Interfaces.Drawable;
import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.implemented.*;
import sk.stuba.fei.oop.implemented.Elements.*;

import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class MCanvas extends Canvas implements NetCanvas {


    private  ArrayList<Drawable> shapes = new ArrayList<>();
    private PetriNet net = new PetriNet();
    private IdGenerator idGenerator = new IdGenerator(0,this);


    public MCanvas() {

    }



    public boolean idChecker(long ID){
        for (Drawable dr:shapes) {
            if(dr.getSuperId() == ID){
                return true;
            }
        }
        return false;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public void clearElements(){
        shapes.clear();
    }

    public void _addMouseListener(MouseListener mouseListener){
        this.addMouseListener(mouseListener);
    }
    public void _removeMouseListener(){
        this.turnInActive();
        for (MouseListener m:this.getMouseListeners()) {
            this.removeMouseListener(m);
        }
    }

    public void turnActive(){
        for (Drawable dr:shapes) {
            if(dr instanceof Transition2D){
                ((Transition2D)dr).setRunning(true);
            }

        }
        this.repaint();
    }
    public void turnInActive(){
        for (Drawable dr:shapes) {
            if(dr instanceof Transition2D){
                ((Transition2D)dr).setRunning(false);
            }

        }
        this.repaint();
    }


    public void fillShapes(){
        shapes.clear();
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
            else if(myedge instanceof OutEdge){
                setShapes(new OutEdge2D((OutEdge)myedge));
            }
            else if(myedge instanceof ResEdge){
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

    @Override
    public void makeElementHighligted(Drawable drawable) {
        drawable.highlight();
    }

    @Override
    public void makeElementUnHighligted(Drawable drawable) {
        drawable.unHighlight();
    }


    public PetriNet getNet() {
        return net;
    }

    public void setNet(PetriNet net) {
        this.net = net;
    }


}
