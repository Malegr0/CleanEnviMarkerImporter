package data;

import javax.swing.*;

public class Frame {

    Frame() {
        JFrame frame = new JFrame("Send Data to Markers Database");
        JPanel panel = new JPanel();

        //create components

        //adding components to panel

        //button listener logic

        //frame settings
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
