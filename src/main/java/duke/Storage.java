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
    private static final Charset ENCODING = Charset.defaultCharset();

    public static void load() throws IOException { // or boolean?
        if (FILE.length() == 0) {
            return;
        }
        byte[] encoded = Files.readAllBytes(Paths.get(FILE_PATH));
        TaskList.setup(new String(encoded, ENCODING));
    }

    public static void save() throws IOException {
        FileWriter writer = new FileWriter(FILE, false);
        writer.write(TaskList.format());
        writer.close();
    }
}