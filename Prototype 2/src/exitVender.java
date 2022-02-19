import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class exitVender {
    public JPanel exitPanel;
    private JLabel Intructions;
    private JButton ticketReturnButton;
    private JLabel gateOpeningLabel;

    public exitVender() {
        ticketReturnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Thank you please come again.");              //popup for after ticket is returned
                gateOpeningLabel.setVisible(true);                                                                      //"opening" the gate to leave
                JFrame vendor = new JFrame("Vendor");                                                              //Makes the frame for main vendor again
                vendor.setContentPane(new Vendor().Vendor);                                                             //attaches the panel to the frame
                vendor.setPreferredSize(new Dimension(1500, 950));                                          //setting size of frame
                vendor.setSize(1500,950);                                                                   //setting size of frame
                vendor.setVisible(true);                                                                                //allowing it to be seen
                JOptionPane.showMessageDialog(null, "Welcome to the parking garage, \n" +         //directions for the main vendor
                        "when you are finished reading this message hit okay and then \n" +
                        "you can proceed to selecting how you would like to pay. \n" +
                        "You can either pay in cash, credit or debt. Once you have paid, or before, you can hit \n" +
                        "the level combo box to see what spots are open in the parking garages on which levels.\n" +
                        "Once you have completed all of these you make the proceed to open through\n" +
                        "the opened gate.\n");




            }
        });
    }
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Parking Vendor"); //Makes the frame
        myFrame.setContentPane(new exitVender().exitPanel); //attaches the panel to the frame

        // Using java dimension, set the preferred size - both width and height
        myFrame.setPreferredSize(new Dimension(1500, 950));

        //sets up what happens with the frame is closes
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame

    }
}
