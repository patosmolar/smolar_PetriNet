package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.generated.Importer;
import sk.stuba.fei.oop.generated.Transformer;
import sk.stuba.fei.oop.graphics.actionListeners.AddPlaceListener;
import sk.stuba.fei.oop.graphics.buttons.AddPlaceBtn;
import sk.stuba.fei.oop.graphics.buttons.AddTranstionBtn;
import sk.stuba.fei.oop.graphics.buttons.ImportBtn;
import sk.stuba.fei.oop.graphics.buttons.RunBtn;
import sk.stuba.fei.oop.graphics.modes.AddPlace_m;
import sk.stuba.fei.oop.graphics.modes.AddTransition_m;
import sk.stuba.fei.oop.graphics.modes.Run_m;
import sk.stuba.fei.oop.implemented.FileChooser;


import java.awt.*;
import java.awt.event.*;


public class MFrame extends Frame implements ActionListener  {


    protected MCanvas canvas = new MCanvas();

    public MFrame() throws HeadlessException {

        super("PetriNet");

        setLayout(new BorderLayout());
        Panel topPanel = new Panel();

        setSize(800,600);

        ImportBtn importBtn = new ImportBtn("Import");
        AddPlaceBtn addPlaceBtn = new AddPlaceBtn("addPlace",canvas);
        AddTranstionBtn addTranstionBtn = new AddTranstionBtn("addTransition",canvas);
        RunBtn runBtn = new RunBtn("Run");

        addPlaceBtn.addActionListener(new AddPlaceListener());
        addTranstionBtn.addActionListener(this);
        importBtn.addActionListener(this);
        runBtn.addActionListener(this);

        topPanel.add(importBtn);
        topPanel.add(addTranstionBtn);
        topPanel.add(addPlaceBtn);
        topPanel.add(runBtn);
        this.add("Center",canvas);
        this.add("North",topPanel);
        setSize(800,600);
        this.setVisible(true);
        addWindowListener( new WindowAdapter ()
                           {	public void windowClosing (WindowEvent e)
                           {	dispose();
                               System.exit(0);
                           }
                           }
        );





    }

    @Override
    public void actionPerformed(ActionEvent e) {



        if(e.getSource() instanceof AddPlaceBtn){

        }
        else if(e.getSource() instanceof RunBtn){
            canvas._removeMouseListener();
            canvas._addMouseListener(new Run_m());
        }
        else if(e.getSource()instanceof AddTranstionBtn){
            canvas._removeMouseListener();
            canvas._addMouseListener(new AddTransition_m());
        }
        else if(e.getSource() instanceof ImportBtn){
            try{
                FileChooser fileChooser = new FileChooser(canvas);
                loadNet(fileChooser.getPathToSelectedFile());
                canvas.clearElements();
                draw();
            }
            catch (java.lang.NullPointerException exca){

            }
        }else if(e.getSource() instanceof MCanvas){

        }



    }

    private void loadNet(String path){

        canvas.setNet(new Transformer(new Importer(path).getDocument()).getPn());


    }
    private void draw() {

        canvas.fillShapes();
        canvas.repaint();

    }

    public MCanvas getCanvas() {
        return canvas;
    }
}
