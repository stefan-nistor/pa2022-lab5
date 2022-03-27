package exceptions;

import catalog.Catalog;

import java.io.IOException;

public class SaveCatalogException extends IOException {
    public SaveCatalogException(Catalog catalog) {
        super("Catalog " + catalog.getName() + " cannot be saved.");
    }
}
