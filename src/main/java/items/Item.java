package items;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@JsonTypeInfo( use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Book.class, name = "book"),
        @JsonSubTypes.Type(value = Article.class, name = "article")
})
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class Item implements Serializable {

    private String id;
    private String title;
    private String location;

    private Map<String, Object> tags = new HashMap<>();

    public void addTag(String key, Object obj){
        tags.put(key, obj);
    }

}
