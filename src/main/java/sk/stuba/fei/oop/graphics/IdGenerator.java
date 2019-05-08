package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.implemented.IdAlreadyExists;
import sk.stuba.fei.oop.implemented.PetriNet;

public class IdGenerator {
    private long lastID;
    private MCanvas canvas;

    public IdGenerator(long initialID,MCanvas canvas) {
        this.lastID = initialID;
        this.canvas = canvas;
    }



    public long getNewId() {

        this.lastID = checker(this.lastID);
        System.out.println(this.lastID);
        return this.lastID;
    }
    private long checker(long lastID){

        if(canvas.idChecker(lastID) == true){
            lastID++;

            return checker(lastID);
        }
        else{
           return lastID;
        }

    }
}
