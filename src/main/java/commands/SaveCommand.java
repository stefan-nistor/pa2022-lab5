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
public class SaveCommand implements Command{

    private String path;
    private Catalog catalog;
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void run() {
        try {
            objectMapper.writeValue(new File(path), catalog);
        } catch (FileNotFoundException e) {
            log.error("File {} not found", path);
        } catch (IOException e) {
            log.error("Error at saving catalog {}", catalog);
        }
    }
}
