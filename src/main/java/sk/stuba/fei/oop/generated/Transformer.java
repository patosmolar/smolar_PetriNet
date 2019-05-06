package sk.stuba.fei.oop.generated;

import sk.stuba.fei.oop.implemented.PetriNet;

public class Transformer {

    private Document document;
    private PetriNet pn = new PetriNet();

    public Transformer(Document document) {
        this.document = document;
        transform();
    }

    private void transform(){
        transformPlaces();
        transformTransitions();
        transformEdges();
    }

    private void transformPlaces(){
        for (Place p:document.getPlace()){
            pn.addPlace(p.getId(),p.getLabel(),p.getTokens(),p.getX(),p.getY());
        }
    }
    private void transformTransitions(){
        for (Transition t:document.getTransition()) {
            pn.addTransition(t.getId(),t.getLabel(),t.getX(),t.getY());
        }
    }

    private  void transformEdges(){
        for (Arc a:document.getArc()) {
            if(a.getType() == ArcType.RESET){
                pn.addResEdge(a.getSourceId(),a.getDestinationId(),a.getId());
            }
            else if(a.getType() == ArcType.REGULAR){
                pn.addInEdge(a.getSourceId(),a.getDestinationId(),a.getId(),a.getMultiplicity());
                pn.addOutEdge(a.getSourceId(),a.getDestinationId(),a.getId(),a.getMultiplicity());
            }
        }

    }

    public PetriNet getPn() {
        return pn;
    }
}
