package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * The <code>Storage</code> class is a utility class to load data from a file, if any, and write
 * data to a file to store for future use.
 *
 * @author Zhu Yijie
 */
public class Storage {
    private static final String FILE_PATH = "./data/duke.txt";
    private static final File FILE = new File(FILE_PATH);
    private static final Charset ENCODING = Charset.defaultCharset();
    
    /**
     * Retrieves all data from file and sends data to the TaskList class.
     *
     * @throws IOException If an input or output exception occurred.
     */
    public static List<Task> load() throws IOException { // or boolean?
        if (FILE.length() == 0) {
            throw new IOException();
        }
        
        byte[] encoded = Files.readAllBytes(Paths.get(FILE_PATH));
        String data = new String(encoded, ENCODING).strip();
        
        if (data.isEmpty()) {
            throw new IOException();
        }
        
        return DataParser.parseDataToTask(data);
    }
    
    /**
     * Takes formatted TaskList data and writes it to file.
     *
     * @throws IOException If an input or output exception occurred.
     */
    public static void save(TaskList tasklist) throws IOException {
        FileWriter writer = new FileWriter(FILE, false);
        writer.write(tasklist.format());
        writer.close();
    }
}