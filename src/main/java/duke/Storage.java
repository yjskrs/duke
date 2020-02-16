package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The <code>Storage</code> class is a utility class to load data from a file, if any, and write
 * data to a file to store for future use.
 *
 * @author Zhu Yijie
 */
public class Storage {
    private static final Charset ENCODING = Charset.defaultCharset();
    private static final String directory = "./data/";
    
    public final String filePath;
    private final File file;
    
    public Storage() {
        this.filePath = null;
        this.file = null;
    }
    
    /**
     * Creates a storage space in <code>data</code> directory with the provided filePath.
     *
     * @param fileName File path provided by user.
     */
    public Storage(String fileName) {
        this.filePath = directory + fileName;
        this.file = new File(this.filePath);
    }
    
    public static String listExistingFiles() {
        File[] files = new File("./data").listFiles((dir, name) -> name.endsWith(".txt"));
        return Arrays.stream(files).map(File::getName).collect(Collectors.joining(DataParser.NEWLINE));
    }
    
    /**
     * Retrieves all data from file and sends data to the TaskList class.
     *
     * @throws IOException If an input or output exception occurred.
     */
    public List<Task> load() throws IOException {
        if (file == null || file.length() == 0) {
            throw new IOException();
        }
        
        byte[] encoded = Files.readAllBytes(Paths.get(filePath));
        String data = new String(encoded, ENCODING).strip();
        
        if (data.isEmpty()) {
            throw new IOException();
        }
        
        return DataParser.parseDataToTask(data);
    }
    
    /**
     * Takes formatted TaskList data and writes it to file.
     *
     * @param tasklist TaskList to store.
     * @throws IOException If an input or output exception occurred.
     */
    public void save(TaskList tasklist) throws IOException {
        FileWriter writer = new FileWriter(file, false);
        writer.write(tasklist.format());
        writer.close();
    }
    
    public boolean isUninitialized() {
        return file == null;
    }
}
