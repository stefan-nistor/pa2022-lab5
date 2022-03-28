import catalog.Catalog;
import commands.*;
import exceptions.InvalidPathException;
import exceptions.SaveCatalogException;
import items.Article;
import items.Book;
import catalog.CatalogUtil;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, URISyntaxException {
        Catalog catalog = new Catalog("catalog", new ArrayList<>());
        var book = new Book("knuth67", "Art of CP", "book.txt");
        var article = new Article("java17", "java spec", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");

        var addBook = new AddCommand(catalog, book);
        var addArticle = new AddCommand(catalog, article);

        addArticle.run();
        addBook.run();

        var save = new SaveCommand(catalog, "catalog.json");
        save.run();

        var list = new ListCommand(catalog);
        list.run();

        var view = new ViewCommand(article);
        view.run();

        var report = new ReportCommand(catalog);
        report.run();
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