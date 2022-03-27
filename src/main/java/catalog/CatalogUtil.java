package catalog;

import com.fasterxml.jackson.databind.ObjectMapper;
import exceptions.InvalidPathException;
import exceptions.LoadCatalogException;
import exceptions.SaveCatalogException;
import items.Item;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Slf4j
public class CatalogUtil {

    public static void save (Catalog catalog, String path) throws InvalidPathException, SaveCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), catalog);
        } catch (FileNotFoundException e) {
            throw new InvalidPathException(path);
        } catch (IOException e) {
            throw new SaveCatalogException(catalog);
        }
    }

    public static Catalog load (String path) throws InvalidPathException, LoadCatalogException {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog loadedCatalog = new Catalog();
        try {
            loadedCatalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (FileNotFoundException e) {
            throw new InvalidPathException(path);
        } catch (IOException e) {
            throw new LoadCatalogException(loadedCatalog);
        }
        return loadedCatalog;
    }

    public static void view(Item item) {
        Desktop desktop = Desktop.getDesktop();
        final String itemLocation = item.getLocation();
        try {
            switch (item.getClass().getName()) {
                case "Book":
                    desktop.open(new File(itemLocation));
                case "Article":
                    desktop.browse(new URI(itemLocation));
            }
        } catch (IOException e) {
            log.error("Specified file has no associated application or associated application failed to launch");
        } catch (URISyntaxException e) {
            log.error("Invalid URI");
        }
    }

}
