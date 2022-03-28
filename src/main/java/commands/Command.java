package commands;

import catalog.Catalog;
import exceptions.InvalidPathException;
import items.Item;

public interface Command {
    void run() throws InvalidPathException;
}
