public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = Logger.getLogger();
        Logger logger2 = Logger.getLogger();


        logger1.log("Message from logger 1");
        logger2.log("Message from logger 2");

        if (logger1 == logger2) {
            System.out.println("They are the same instance");
        }
    }
}
