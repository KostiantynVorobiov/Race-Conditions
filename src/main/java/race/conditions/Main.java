package race.conditions;

import org.apache.log4j.Logger;
import race.conditions.thread.ThreadFromRunnable;
import race.conditions.thread.ThreadFromThread;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        Counter counter = new Counter();
        ThreadFromRunnable threadFromRunnable = new ThreadFromRunnable(counter);
        ThreadFromThread threadFromThread = new ThreadFromThread(counter);
        logger.info("Start thread extends Thread");
        threadFromThread.start();
        Thread threadFromInterface = new Thread(threadFromRunnable);
        logger.info("Start thread implements Runnable");
        threadFromInterface.start();
    }
}
