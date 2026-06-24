public class Logger {

    private Logger() {
        System.out.println("Logger created");
    }
    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            logger = new Logger();
        }
        return logger;
    }

    public void log(String logMessage) {
        System.out.println(">" + logMessage);
    }


}
