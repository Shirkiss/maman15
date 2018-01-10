import javax.swing.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by shir.cohen on 1/10/2018.
 */
public class TimerThread extends Thread {
    public Boolean stop = false;
    public int done = 0;
    private JTextArea output;
    public TrafficLightThread t1;


    public TimerThread(JTextArea txt) {
        output = txt;
    }

    public void run() {
        t1 = new TrafficLightThread(this, output);

        t1.start();
        while (done < 10) {
            stop = false;
            try {
                TimerThread.sleep(3000);
            } catch (InterruptedException e) {
            }
            setStop();
        }
        // System.out.println("Finished");
        output.append("Finished" + "\n");
    }

    public void setStop() {
//        t1.lock.lock();
        stop = true;
        done++;
        t1.condition.signal();
//        t1.lock.unlock();
    }

}
