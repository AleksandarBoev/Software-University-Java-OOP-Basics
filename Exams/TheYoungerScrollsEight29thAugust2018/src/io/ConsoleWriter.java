package io;

import interfaces.OutputWriter;

public class ConsoleWriter implements OutputWriter {
    @Override
    public void writeLine(String output) {
        System.out.println(output);
    }

    @Override
    public void write(String output) {
        System.out.print(output);
    }

    @Override
    public void writeLineFormat(String output, String... args) {
        output = output + "%n";
        System.out.printf(output, args);
    }

    @Override
    public void writeFormat(String output, String... args) {
        System.out.printf(output, args);
    }
}
