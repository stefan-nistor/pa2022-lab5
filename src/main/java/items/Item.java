package items;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public abstract class Item implements Serializable {

    private String id;
    private String title;
    private String location;

    private Map<String, Object> tags = new HashMap<>();

    public Item(){
        this.id = null;
        this.title = null;
        this.location = null;
    }

    public Item(String id, String title, String location){
        this.id = id;
        this.title = title;
        this.location = location;
    }

    public void addTag(String key, Object obj){
        tags.put(key, obj);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Map<String, Object> getTags() {
        return tags;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getTitle() {
        return title;
    }

}
