package data;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

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
            String longitudeStr = longitudeTextField.getText();
            String latituteStr = latituteTextField.getText();
            String name = nameTextField.getText();
            String address = addressTextField.getText();

            if(!longitudeStr.equals("") && !latituteStr.equals("") && !name.equals("") && !address.equals("")) {
                boolean response = false;
                try {
                    response = URLCreator.sendPostRequest(longitudeStr, latituteStr, name, address);
                } catch (InterruptedException | IOException interruptedException) {
                    interruptedException.printStackTrace();
                }
                if(response) {
                    JOptionPane.showMessageDialog(null, "Sending of data was successful.", "InfoBox: Successful Sending", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Sending of data was not successful.", "InfoBox: Unsuccessful Sending", JOptionPane.INFORMATION_MESSAGE);
                }
                longitudeTextField.setText("");
                latituteTextField.setText("");
                nameTextField.setText("");
                addressTextField.setText("");
            } else {
                JOptionPane.showMessageDialog(null, "There has to be text in each textfields.", "InfoBox: Data wasn't send.", JOptionPane.INFORMATION_MESSAGE);
            }

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
