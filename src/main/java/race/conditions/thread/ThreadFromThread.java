package race.conditions.thread;

import org.apache.log4j.Logger;
import race.conditions.Counter;

public class ThreadFromThread extends Thread {
    private static final Logger logger = Logger.getLogger(ThreadFromThread.class);
    private Counter counter;

    public ThreadFromThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while (counter.getCount() < 100) {
            counter.increment();
            logger.info(Thread.currentThread().getName() + " value: " + counter.getCount());
        }
    }
}
