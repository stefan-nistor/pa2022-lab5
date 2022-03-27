package commands;

import catalog.Catalog;
import items.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddCommand implements Command{
    private Catalog catalog;
    private Item item;
    @Override
    public void run() {
        catalog.addItem(item);
    }

}