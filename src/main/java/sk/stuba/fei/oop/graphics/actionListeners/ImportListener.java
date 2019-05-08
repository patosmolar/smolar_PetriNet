package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.generated.Importer;
import sk.stuba.fei.oop.generated.Transformer;
import sk.stuba.fei.oop.graphics.MCanvas;
import sk.stuba.fei.oop.graphics.NetCanvas;
import sk.stuba.fei.oop.implemented.FileChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImportListener extends BaseListener {


    public ImportListener(NetCanvas canvas) {
        super(canvas);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("IMPORT");
        try{
            FileChooser fileChooser = new FileChooser();
            loadNet(fileChooser.getPathToSelectedFile());
            super.getCanvas().clearElements();
            draw();
        }
        catch (java.lang.NullPointerException exca){

        }


    }

    private void loadNet(String path){

        super.getCanvas().setNet(new Transformer(new Importer(path).getDocument()).getPn());


    }
    private void draw() {

        super.getCanvas().fillShapes();
        super.getCanvas().repaint();

    }
}
