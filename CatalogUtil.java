
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author adria
 */
public class CatalogUtil {

    public static void save(Catalog catalog)
            throws IOException {
        try (var oos = new ObjectOutputStream(new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws InvalidCatalogException, IOException, ClassNotFoundException {
        try (var ois = new ObjectInputStream(new FileInputStream(path))) {
            Catalog catalog = (Catalog) ois.readObject();
            return catalog;
        }
    }

    public static void view(Document doc) throws IOException{
        Desktop desktop = Desktop.getDesktop(); //… browse or open, depending of the location type
        File f = new File(doc.location);
        desktop.open(f);
    }
}

