package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

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
     * Retrieves all data from file and returns data as a string.
     *
     * @return Data string loaded from file.
     * @throws IOException If an input exception occurred.
     * @throws EmptyFileException If the file read is empty.
     */
    public static String load() throws IOException, EmptyFileException {
        if (isEmpty()) {
            throw new EmptyFileException();
        }
        byte[] encoded = Files.readAllBytes(Paths.get(FILE_PATH));
        return new String(encoded, ENCODING);
    }
    
    /**
     * Takes formatted TaskList data and writes it to file.
     *
     * @throws IOException If an input or output exception occurred.
     */
    public static void save(String data) throws IOException {
        FileWriter writer = new FileWriter(FILE, false);
        writer.write(data);
        writer.close();
    }
    
    /**
     * Checks if FILE is empty.
     *
     * @return True if empty, false otherwise.
     */
    public static boolean isEmpty() {
        return FILE.length() == 0;
    }
}