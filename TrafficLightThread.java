import javax.swing.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shir.cohen on 1/10/2018.
 */
public class TrafficLightThread extends Thread {
    private TimerThread t;
    private JTextArea output;
    public Lock lock = new ReentrantLock();
    public Condition condition = lock.newCondition();


    public TrafficLightThread(TimerThread t, JTextArea txt) {
        this.t = t;
        output = txt;
    }

    public synchronized void run() {
        System.out.println("I am run");
        while (t.done < 10) {
            lock.lock();
            try {
                if (!t.stop){
                    System.out.println("I am not stop");
                    output.append("lights are ON\n");
                } else {
                    System.out.println("I am stop");
                    output.append("lights are OFF\n");
                }
                condition.await();
                lock.unlock();
            } catch (InterruptedException e) {}
        }
    }
}
