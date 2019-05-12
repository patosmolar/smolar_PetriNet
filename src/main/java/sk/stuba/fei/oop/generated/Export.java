package sk.stuba.fei.oop.generated;



import sk.stuba.fei.oop.implemented.*;
import sk.stuba.fei.oop.implemented.Elements.*;

import javax.xml.bind.JAXBContext;



import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;


public class Export {

    private String path;
    private PetriNet net;

    public Export(PetriNet net) {
        this.net = net;
    }


    public void exportToXml(String path){
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(Document.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            ObjectFactory of = new ObjectFactory();
            Document document = of.createDocument();
            marshalTransition(document,of);
            marshalPlaces(document,of);

            File file = new File(path+ ".xml");


            marshaller.marshal(document,file);
        } catch (JAXBException e) {
            System.out.println(e.getCause());
        }
    }

    private void marshalTransition(Document document, ObjectFactory of){
        for (sk.stuba.fei.oop.implemented.Elements.Transition tr : net.gettList()) {
            Transition transition =of.createTransition();
            transition.setId((int)tr.getID());
            transition.setX((int)tr.getX());
            transition.setY((int)tr.getY());
            transition.setLabel(tr.getName());
            document.getTransition().add(transition);
            marshalEdges(document,of,tr);
        }
    }

    private void marshalEdges(Document document, ObjectFactory of, sk.stuba.fei.oop.implemented.Elements.Transition transition){

        for (BaseEdge edge : transition.getEdgess()){
            if(!(edge instanceof ResEdge)){
                Arc arc = of.createArc();
                if(edge instanceof OutEdge){
                    arc.setSourceId((int)(edge.getP().getID()));
                    arc.setDestinationId((int)(edge.getT().getID()));
                }else if (edge instanceof InEdge){
                    arc.setSourceId((int)(edge.getT().getID()));
                    arc.setDestinationId((int)(edge.getP().getID()));
                }

                arc.setId((int)edge.getID());
                arc.setMultiplicity(((Edge)edge).getWeight());
                arc.setType(ArcType.REGULAR);
                document.getArc().add(arc);
            }

        }

        for (BaseEdge resEdge : transition.getEdgess()) {
            if(resEdge instanceof ResEdge){
                Arc arc = of.createArc();
                arc.setId((int)resEdge.getID());
                arc.setSourceId((int)(resEdge.getP().getID()));
                arc.setDestinationId((int)(resEdge.getT().getID()));
                arc.setType(ArcType.RESET);
                document.getArc().add(arc);
            }


        }

    }

    private void marshalPlaces(Document document, ObjectFactory of){
        for (sk.stuba.fei.oop.implemented.Elements.Place pl : net.getpList()) {
            Place place = of.createPlace();
            place.setId((int)pl.getID());
            place.setX((int)pl.getX());
            place.setTokens((int)pl.getValue());
            place.setY((int)pl.getY());
            place.setLabel(pl.getName());
            document.getPlace().add(place);
        }
    }
}







