package data;

import javax.swing.*;
import java.awt.*;

public class Frame {

    Frame() {
        JFrame frame = new JFrame("Send Data to Markers Database");
        JPanel panel = new JPanel();

        //create components
        JLabel longitudeLabel = new JLabel("Longitude:");
        JTextField longitudeTextField = new JTextField();
        longitudeTextField.setPreferredSize(new Dimension(100, longitudeTextField.getPreferredSize().height));

        JLabel latituteLabel = new JLabel("Latitute:");
        JTextField latituteTextField = new JTextField();
        latituteTextField.setPreferredSize(new Dimension(100, latituteTextField.getPreferredSize().height));

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(100, nameTextField.getPreferredSize().height));

        JLabel addressLabel = new JLabel("Address:");
        JTextField addressTextField = new JTextField();
        addressTextField.setPreferredSize(new Dimension(200, addressTextField.getPreferredSize().height));

        JButton sendingButton = new JButton("Send data!");

        //button listener logic

        sendingButton.addActionListener(e -> {

        });

        //adding components to panel
        panel.add(longitudeLabel);
        panel.add(longitudeTextField);
        panel.add(latituteLabel);
        panel.add(latituteTextField);
        panel.add(nameLabel);
        panel.add(nameTextField);
        panel.add(addressLabel);
        panel.add(addressTextField);
        panel.add(sendingButton);

        //frame settings
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
