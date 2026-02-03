package logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {
    private static Logger instance;   // Singleton instance
    private BufferedWriter writer;
    private String fileName;


    private Logger() {
        this.fileName = "default_log.txt"; // default file name
        openFile(fileName);
    }


    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }


    private void openFile(String fileName) {
        try {
            writer = new BufferedWriter(new FileWriter(fileName, true)); // append mode
        } catch (IOException e) {
            System.err.println("Error opening log file: " + e.getMessage());
        }
    }


    public synchronized void setFileName(String newFileName) {
        close(); // close current file
        this.fileName = newFileName;
        openFile(newFileName);
    }


    public synchronized void write(String message) {
        try {
            if (writer != null) {
                writer.write(message);
                writer.newLine();
                writer.flush();
            }
        } catch (IOException e) {
            System.err.println("Error writing log: " + e.getMessage());
        }
    }


    public synchronized void close() {
        try {
            if (writer != null) {
                writer.close();
                writer = null;
            }
        } catch (IOException e) {
            System.err.println("Error closing log file: " + e.getMessage());
        }
    }
}