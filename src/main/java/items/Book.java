package items;

public class Book extends Item {
    String id;
    String title;
    String location;
    public Book(String id, String title, String location){
        this.id = id;
        this.location = location;
        this.title = title;
    }
}
