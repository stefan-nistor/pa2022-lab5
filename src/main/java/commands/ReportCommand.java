package commands;

import catalog.Catalog;
import freemarker.core.ParseException;
import freemarker.template.*;
import items.Article;
import items.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.*;

@Data
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ReportCommand implements Command {

    private Catalog catalog;

    @Override
    public void run() throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_31);
        configuration.setDirectoryForTemplateLoading(new File("report"));
        configuration.setDefaultEncoding("UTF-8");
        configuration.setLocale(Locale.US);
        configuration.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        Map<String, Object> root = new HashMap<>();
        root.put("catalog", catalog);

        List<Book> bookList = new ArrayList<>();
        List<Article> articleList = new ArrayList<>();

        catalog.getItems().forEach(item -> {
            if (item instanceof Book)
                bookList.add((Book) item);
            if (item instanceof Article)
                articleList.add((Article) item);
        });

        root.put("books", bookList);
        root.put("articles", articleList);

        Template template = null;

        try {
            template = configuration.getTemplate("report.ftl");
        } catch (TemplateNotFoundException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            log.error("Error at parsing template.");
        } catch (MalformedTemplateNameException e) {
            log.error("Malformed template.");
        } catch (IOException e) {
            log.error("I/O Error has occurred.");
        }

        Writer htmlWriter = null;
        try {
            htmlWriter = new FileWriter("report.html");
        } catch (IOException e) {
            log.error("I/O Error has occurred");
        }

        try {
            template.process(root, htmlWriter);
        } catch (TemplateException e) {
            log.error("Cannot process template.");
        }

        File htmlFile = new File("report.html");
        Desktop desktop = Desktop.getDesktop();
        if (htmlFile.exists())
            try {
                desktop.open(htmlFile);
            } catch (IOException e) {
                log.error("Specified file has no associated application or associated application failed to launch");
            }
    }
}
