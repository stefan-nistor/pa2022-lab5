package items;

public class Article extends Item{
    String id;
    String title;
    String location;
    public Article(String id, String title, String location){
        this.id = id;
        this.location = location;
        this.title = title;
    }
}
