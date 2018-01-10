


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Shay Tavor
 */
import java.awt.GridLayout;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
        import java.util.concurrent.ExecutorService;
        import java.util.concurrent.Executors;
        import javax.swing.*;

public class TrafficLightGUI extends JPanel {
    private JButton cmdBusyWaiting;
    private JLabel lblTitle;
    private JScrollPane jScrollPane1;
    private JTextArea txtOutput;

    public TrafficLightGUI()
    {
        cmdBusyWaiting = new JButton("Busy Waiting");
        lblTitle = new JLabel("Multithreading");
        txtOutput = new JTextArea(10, 20);
        jScrollPane1 = new JScrollPane(txtOutput);
        txtOutput.setFont(new java.awt.Font("Courier New", 0, 24));
        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(0, 0, 255));
        jScrollPane1.setViewportView(txtOutput);

        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 3, 20, 20));
        buttons.add(cmdBusyWaiting);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(lblTitle);
        add(Box.createVerticalGlue());
        add(buttons);
        add(Box.createVerticalGlue());
        add(jScrollPane1);

        Listener l = new Listener();
        cmdBusyWaiting.addActionListener(l);
    }

    private class Listener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == cmdBusyWaiting)
            {
                TimerThread t = new TimerThread(txtOutput);
                t.start();
            }
        }
    }
}

