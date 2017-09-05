package org.jbehave.core.log;

public class LoggerFactory {

    private static final ThreadLocal<Logger> logger = new ThreadLocal<Logger>() {
        @Override
        protected Logger initialValue() {
            return Logger.build();
        }
    };

    private LoggerFactory() {

    }

    public static Logger getLogger() {
        return logger.get();
    }
}
