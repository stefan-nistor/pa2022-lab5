package commands;

import catalog.Catalog;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoadCommand implements Command {

    private String path;
    private ObjectMapper objectMapper;
    private Catalog catalog;

    @Override
    public void run() {
        try {
            this.catalog = objectMapper.readValue(new File(path), Catalog.class);
        } catch (FileNotFoundException e) {
            log.error("File not found.");
        } catch (IOException e) {
            log.error("Invalid catalog");
        }
    }
}
