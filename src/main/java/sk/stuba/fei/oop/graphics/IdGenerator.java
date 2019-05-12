package sk.stuba.fei.oop.graphics;

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

        if(canvas.idChecker(lastID)){
            lastID++;

            return checker(lastID);
        }
        else{
           return lastID;
        }

    }
}
