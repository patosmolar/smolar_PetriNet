package sk.stuba.fei.oop.implemented;

import java.util.ArrayList;


public class PetriNet {

    private ArrayList<Transition> tList = new ArrayList<Transition>();
    private ArrayList<Place> pList = new ArrayList<Place>();
    private ArrayList<BaseEdge> edgesList = new ArrayList<>();

    public PetriNet() {
    }



    public void addTransition(long ID, String name,int x,int y ) {
        try {
            idChecker(ID);
            tList.add(new Transition(ID, name,x,y));
        } catch (IdAlreadyExists e) {
            e.GetOveralMessage(ID);
        }

    }

    public void addPlace(long ID, String name, int value,int x,int y) {
        try {
            idChecker(ID);
            pList.add(new Place(ID, name, value,x,y));
        } catch (IdAlreadyExists e) {

        } catch (IllegalValues e) {

        }

    }

    public void addResEdge(long ID1, long ID2, long ID) {
        try {
            idChecker(ID);
            edgesList.add(new ResEdge(getTransitionByID(ID2), getPlaceByID(ID1), ID));
        } catch (IdAlreadyExists e) {
        } catch (IdNotFoundException e) {
        }
    }


    public void addInEdge(long ID_Transition, long ID_Place, long ID, int weight) {

        try {
            idChecker(ID);
            edgesList.add(new InEdge(getTransitionByID(ID_Transition), getPlaceByID(ID_Place), ID, weight));
        } catch (IdAlreadyExists e) {
        } catch (IdNotFoundException e) {
        } catch (IllegalValues e) {
        }

    }

    public void addOutEdge(long ID_Place, long ID_Transition, long ID, int weight) {

        try {
            idChecker(ID);
            edgesList.add(new OutEdge(getTransitionByID(ID_Transition), getPlaceByID(ID_Place), ID, weight));
        } catch (IdNotFoundException e) {
        } catch (IdAlreadyExists e) {
        } catch (IllegalValues e) {
        }


    }

    public Place getPlaceByID(long ID) throws IdNotFoundException {
        for (Place p : pList) {
            if (p.getID() == ID) {
                return p;
            }
        }
        throw new IdNotFoundException();
    }

    public Transition getTransitionByID(long ID) throws IdNotFoundException {
        for (Transition t : tList) {
            if (t.getID() == ID) {
                return t;
            }
        }
        throw new IdNotFoundException();
    }

    private void idChecker(long ID) throws IdAlreadyExists {
        for (Place p : pList) {
            if (ID == p.getID()) throw new IdAlreadyExists(ID);
        }
        for (Transition t : tList) {
            if (ID == t.getID()) throw new IdAlreadyExists(ID);
        }
        for (BaseEdge b : edgesList) {
            if (ID == b.getID()) throw new IdAlreadyExists(ID);
        }

    }

    public void activateTransition(long ID) {
        try {
            for (Transition t : tList) {
                if (ID == t.getID()) {
                    t.activate();
                    break;
                }

            }

        } catch (IllegalTransmitionActivationExceptioon e) {
            e.GetOveralMessage(ID);
        }

    }

    public void printValues() {
        for (Place p : pList) {
            System.out.println(p.getName() + ":" + p.getValue());
        }
    }

    public ArrayList<Transition> gettList() {
        return tList;
    }

    public ArrayList<Place> getpList() {
        return pList;
    }

    public ArrayList<BaseEdge> getEdgesList() {
        return edgesList;
    }
}
