package sk.stuba.fei.oop.generated;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Importer {

    private String path;
    private Document document;

    public Importer(String path) {

        this.path = path;
        importFromXml();
    }

    private void importFromXml() {

        try {
            File file = new File(path);
            InputStream resource = new FileInputStream(file);
            JAXBContext context = JAXBContext.newInstance(Document.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            this.document = (Document) unmarshaller.unmarshal(resource);


        } catch (JAXBException  e) {
            System.out.println("Chybny XML SUBOR");
        }
        catch (FileNotFoundException e){

        }


    }

    public Document getDocument() {
        return document;
    }
}