package org.jbehave.core.log;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private Logger() {}

    private List<String> messages = new ArrayList<String>();

    public static Logger build() {
        return new Logger();
    }

    /**
     * get all pending messages
     */
    public List<String> getPendingMessages() {
        List<String> pendingMessages = new ArrayList<String>(getMessages());
        getMessages().clear();
        return pendingMessages;
    }

    /**
     * clean all messages
     */
    public void clearMessages() {
        getMessages().clear();
    }

    /**
     * @param message - Custom message that can be added at runtime that will be visible in reports.
     */
    public void writeMessage(LoggerLevel level, String message) {
        final String msg = String.format("[%s] - [%s] - %s", level.toString(), Thread.currentThread().getName(), message);
        System.out.println(msg);
        getMessages().add(msg);
    }

    /**
     * @param format - Custom messages that can be added at runtime that will be visible in reports.
     *                  Format of the string message
     * @param args   - Arguments for the format string as passed into String.format()
     */
    public void writeMessage(String format, String... args) {
        getMessages().add(String.format(format, args));
    }

    /**
     * return messages
     */
    private List<String> getMessages() {
        return this.messages;
    }

    public void info(String message) {
        this.writeMessage(LoggerLevel.INFO, message);
    }

    public void debug(String message) {
        this.writeMessage(LoggerLevel.DEBUG, message);
    }

    public void error(String message) {
        this.writeMessage(LoggerLevel.ERROR, message);
    }

    public void warn(String message) { this.writeMessage(LoggerLevel.WARN, message);}

    public void info(String fmt, String... message) {
        this.writeMessage(String.format(fmt, message));
    }

    public void debug(String fmt, String... message) {
        this.writeMessage(String.format(fmt, message));
    }

    public void error(String fmt, String... message) {
        this.writeMessage(String.format(fmt, message));
    }

    public void warn(String fmt, String... message) { this.writeMessage(String.format(fmt, message));}

    private enum LoggerLevel {
        DEBUG,
        INFO,
        ERROR,
        WARN
    }
}
