package commands;

import exceptions.InvalidItemType;
import exceptions.InvalidPathException;
import items.Item;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ViewCommand implements Command {

    private Item item;

    @Override
    public void run() throws InvalidPathException {
        Desktop desktop = Desktop.getDesktop();
        final String itemLocation = item.getLocation();
        try {
            switch (item.getClass().getName()) {
                case "items.Book":
                    desktop.open(new File(itemLocation));
                case "items.Article":
                    desktop.browse(new URI("https://youtu.be/dQw4w9WgXcQ"));
                default:
                    throw new InvalidItemType(item.getClass().getName());
            }
        } catch (IOException e) {
            log.error("Specified file has no associated application or associated application failed to launch");
        } catch (URISyntaxException e) {
            throw new InvalidPathException(itemLocation);
        } catch (InvalidItemType e) {
            log.error(e.toString());
        }

    }
}
