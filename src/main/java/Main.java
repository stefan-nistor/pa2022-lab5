import catalog.Catalog;
import exceptions.InvalidCatalogException;
import items.Article;
import items.Book;
import catalog.CatalogUtil;

public class Main {
    public static void main(String[] args) throws InvalidCatalogException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();
    }

    private void testCreateSave() throws InvalidCatalogException {
        Catalog catalog = new Catalog();
        //var book = new Book("knuth67", "Art of CP", "/home/nistor/Documents");
        var article = new Article("java17", "java spec", "https://docs.oracle.com/javase/specs/jls/se17/html/index.html");
        //catalog.addItem(book);
        catalog.addItem(article);
        CatalogUtil.save(catalog, "/home/nistor/Documents/catalog.json");
    }

    private void testLoadView() throws InvalidCatalogException {
        Catalog catalog = CatalogUtil.load("/home/nistor/Documents/catalog.json");
        CatalogUtil.view(catalog.findById("java17"));
    }

}
