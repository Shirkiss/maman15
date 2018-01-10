/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shay Tavor
 */
import javax.swing.JFrame;
public class Tester {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Multithreading Tester");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        TrafficLightGUI t = new TrafficLightGUI();
        frame.add(t);
        frame.setVisible(true);
    }

}
