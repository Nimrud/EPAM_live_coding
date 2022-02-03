package pl.jaczewski.livecoding.patterns.command;

import java.io.*;

class CopyCommand implements Command {
    @Override
    public boolean execute(String[] input) {
        try {
            final FileInputStream fileInputStream = new FileInputStream(input[1]);
            final FileOutputStream fileOutputStream = new FileOutputStream(input[2]);
            int data;
            while ((data = fileInputStream.read()) >= 0) {
                fileOutputStream.write(data);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        } catch (IOException e) {
            System.err.println("Could not perform operation");
        }
        return false;
    }
}
