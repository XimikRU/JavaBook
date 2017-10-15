package book.samples;
import book.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class timerListener implements ActionListener
{
    public void logic()
    {
        ActionListener listener = new timerListener();
        Timer t = new Timer(10000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "quit?");
        System.exit(0);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        Date now = new Date();
        System.out.println("at the one: " + now);
        Toolkit.getDefaultToolkit().beep();
    }
}
