package exceptions;

import catalog.Catalog;

import java.io.IOException;

public class LoadCatalogException extends IOException {
    public LoadCatalogException(Catalog catalog){
        super("Catalog " + catalog.getName() + " cannot be loaded.");
    }
}
