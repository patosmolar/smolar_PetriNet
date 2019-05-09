package sk.stuba.fei.oop.graphics;

import sk.stuba.fei.oop.generated.Importer;
import sk.stuba.fei.oop.generated.Transformer;
import sk.stuba.fei.oop.graphics.actionListeners.*;
import sk.stuba.fei.oop.graphics.buttons.*;
import sk.stuba.fei.oop.graphics.modes.AddPlace_m;
import sk.stuba.fei.oop.graphics.modes.AddTransition_m;
import sk.stuba.fei.oop.graphics.modes.Run_m;
import sk.stuba.fei.oop.implemented.FileChooser;


import java.awt.*;
import java.awt.event.*;


public class MFrame extends Frame{


    protected MCanvas canvas = new MCanvas();


    public MFrame() throws HeadlessException {

        super("PetriNet");

        setLayout(new BorderLayout());
        Panel topPanel = new Panel();

        setSize(800,600);

        ImportBtn importBtn = new ImportBtn("Import");
        AddPlaceBtn addPlaceBtn = new AddPlaceBtn("Place");
        AddTranstionBtn addTranstionBtn = new AddTranstionBtn("Transition");
        RunBtn runBtn = new RunBtn("Run");
        AddEdgeBtn edgeBtn = new AddEdgeBtn("Edge");

        addPlaceBtn.addActionListener(new AddPlaceListener(canvas));
        addTranstionBtn.addActionListener(new AddTransitionListener(canvas));
        importBtn.addActionListener(new ImportListener(canvas));
        runBtn.addActionListener(new RunListener(canvas));
        edgeBtn.addActionListener(new AddEdgeListener(canvas));

        topPanel.add(importBtn);
        topPanel.add(addTranstionBtn);
        topPanel.add(addPlaceBtn);
        topPanel.add(runBtn);
        topPanel.add(edgeBtn);
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


    public MCanvas getCanvas() {
        return canvas;
    }
}
