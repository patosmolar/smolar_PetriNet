package sk.stuba.fei.oop.implemented;

public abstract class Edge extends BaseEdge {

    private int weight;


    public Edge(Transition t, Place p, long ID, int weight) throws IllegalValues {

        super(t, p, ID);
        setWeight(weight);
    }


    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) throws IllegalValues {
        if (weight <= 0) {
            throw new IllegalValues("Nasobnost musi byt vacsia ako 0");
        }
        this.weight = weight;
    }


    public abstract void moveTokens() throws IllegalTransmitionActivationExceptioon;
}
