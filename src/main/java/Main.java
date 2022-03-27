import catalog.Catalog;
import exceptions.InvalidPathException;
import exceptions.LoadCatalogException;
import exceptions.SaveCatalogException;
import items.Article;
import items.Book;
import catalog.CatalogUtil;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws SaveCatalogException, InvalidPathException {
        Catalog catalog = new Catalog();
        var book = new Book("knuth67", "Art of CP", "/home/nistor/Documents/book.txt");
        var article = new Article("java17", "java spec", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        catalog.addItem(book);
        catalog.addItem(article);
        catalog.setName("catalog");
        CatalogUtil.save(catalog, "/home/nistor/Documents/catalog.json");
    }

    private void testLoadView() throws IOException, URISyntaxException {
        Catalog catalog = CatalogUtil.load("/home/nistor/Documents/catalog.json");
        CatalogUtil.view(catalog.findById("java17"));
    }
}