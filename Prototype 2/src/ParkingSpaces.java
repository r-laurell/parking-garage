import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class ParkingSpaces {
    public JLabel P1;
    public JLabel P2;
    public JLabel P3;
    public JLabel P4;
    public JLabel P5;
    public JLabel P6;
    public JLabel P7;
    public JLabel P8;
    public JLabel P9;
    public JLabel P10;
    public JLabel P11;
    public JLabel P12;
    public JLabel P13;
    public JLabel P14;
    public JLabel P15;
    public JLabel P16;
    public JLabel P17;
    public JLabel P18;
    public JLabel P19;
    public JLabel P20;
    public JLabel P21;
    public JLabel P22;
    public JLabel P24;
    public JLabel P25;
    public JLabel P26;
    public JLabel P27;
    public JLabel P28;
    public JLabel P29;
    public JLabel P30;
    public JLabel P23;
    public JPanel ParkingSpacesFrame;
    private JLabel L2;
    private JLabel L3;
    private JLabel L1;
    public JFrame parkingFrame;


    public void windowClosing(WindowEvent e) {
        JOptionPane.showMessageDialog(null, "Welcome to the parking garage, \n" +
                "when you are finished reading this message hit okay and then \n" +
                "you can proceed to selecting how you would like to pay. \n" +
                "You can either pay in cash, credit or debt. Once you have paid, or before, you can hit \n" +
                "the level combo box to see what spots are open in the parking garages on which levels.\n" +
                "Once you have completed all of these you make the proceed to open through\n" +
                "the opened gate.\n");
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Parking Vendor"); //Makes the frame
        myFrame.setContentPane(new ParkingSpaces().ParkingSpacesFrame); //attaches the panel to the frame

        // Using java dimension, set the preferred size - both width and height
        myFrame.setPreferredSize(new Dimension(1500, 950));

        //sets up what happens with the frame is closes
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame

    }
}
