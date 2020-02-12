package duke;

public class EmptyFileException extends Exception {
    public EmptyFileException() {
        super("File is empty.");
    }
}
