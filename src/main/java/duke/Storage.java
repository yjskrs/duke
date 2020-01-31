package duke;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Storage {
    private static final String FILE_PATH = "./data/duke.txt";
    private static final File FILE = new File(FILE_PATH);
    private static final Charset encoding = Charset.defaultCharset();

    public static String load() throws IOException {
        if (FILE.length() == 0) {
            return "";
        }
        byte[] encoded = Files.readAllBytes(Paths.get(FILE_PATH));
        return new String(encoded, encoding);
    }

    public static void save(String formattedData) throws IOException {
        FileWriter writer = new FileWriter(FILE, false);
        writer.write(formattedData);
        writer.close();
    }
}
