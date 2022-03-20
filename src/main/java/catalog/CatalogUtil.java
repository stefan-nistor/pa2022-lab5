package catalog;

import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.InvalidCatalogException;
import items.Item;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CatalogUtil {

    public static void save (Catalog catalog, String path) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), catalog);
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }
    }

    public static Catalog load (String path) throws InvalidCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), Catalog.class);
        } catch (IOException e) {
            throw new InvalidCatalogException(e);
        }
    }

    public static void view(Item item) {
        Desktop desktop = Desktop.getDesktop();
    }

}
