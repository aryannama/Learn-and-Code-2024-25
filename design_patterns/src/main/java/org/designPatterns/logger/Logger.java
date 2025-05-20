package org.designPatterns.logger;

public class Logger {
    private static Logger logger;

    private Logger() {
    }

    public static Logger getLogger() {
        if (logger == null) {
            synchronized (Logger.class) {
                if (logger == null) {
                    logger = new Logger();
                }
            }
        }
        return logger;
    }

    public void info(String message) {
        System.out.println("[INFO] " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR] " + message);
    }

    public void debug(String message) {
        System.out.println("[DEBUG] " + message);
    }
}
