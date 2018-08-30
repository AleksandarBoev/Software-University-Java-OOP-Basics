package interfaces;

public interface OutputWriter {
    void writeLine(String output);

    void write(String output);

    void writeLineFormat(String output, String...args);

    void writeFormat(String output, String...args);
}
