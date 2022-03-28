package commands;

import catalog.Catalog;
import exceptions.InvalidPathException;
import items.Item;

import java.io.IOException;

public interface Command {
    void run() throws IOException;
}
