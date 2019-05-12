package sk.stuba.fei.oop.graphics.actionListeners;

import sk.stuba.fei.oop.generated.Export;
import sk.stuba.fei.oop.graphics.Interfaces.NetCanvas;
import sk.stuba.fei.oop.generated.FileChooser;

import java.awt.event.ActionEvent;

public class ExportListener extends BaseListener {


    public ExportListener(NetCanvas canvas) {
        super(canvas);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("EXPORT");
        new Export(getCanvas().getNet()).exportToXml(new FileChooser().choosePathtoDirectory());

    }


}
