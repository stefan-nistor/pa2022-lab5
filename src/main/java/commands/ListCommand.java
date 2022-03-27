package commands;

import catalog.Catalog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCommand implements Command {

    private Catalog catalog;

    @Override
    public void run() {
        catalog.getItems().forEach(item -> System.out.println(item.toString()));
    }

}
