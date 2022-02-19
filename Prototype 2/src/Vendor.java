import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.AccessControlContext;
import javax.swing.JOptionPane;

public class Vendor {
    private JLabel parkingLabel;
    private JLabel changeLabel;
    private JLabel questionLabel;
    private JLabel level;
    public JPanel Vendor;
    private JLabel carIncreaseCounter;
    private JComboBox levelComboBox;
    private JComboBox paymentBox;
    private JButton exitButton;
    private JButton cancelButton;
    private JButton cashButton;
    private JButton debitButton;
    private JButton creditButton;
    private JLabel PaymentLabel;
    private JButton instructionsButton;
    //int carCounter = 0;                                                             //car counter variable
    public char[][] spaceByLevel = {{'O','O','O','O','O','O','O','O','O','O'},      //parking spaces by level array
                             {'O','O','O','O','O','O','O','O','O','O'},
                             {'O','O','O','O','O','O','O','O','O','O'}};
    private final ParkingSpaces parkingGarage = new ParkingSpaces();                //calling the parking spaces form

    public void updateShowParkingSpaces(){
        int pSpace = 0;                                                             //initializing the parking space variable to pass in the parking space
        int level = 0;                                                              //initializing the level variable to pass in the level
        int currLabel = 0;                                                          //initializing a current label variable to know where we are
        int temp = 0;                                                               //initializing a temp variable for passing in values to store in

        JFrame parkingFrame = new JFrame("ParkingSpaces");                      //Makes the frame
        parkingFrame.setContentPane(new ParkingSpaces().ParkingSpacesFrame);        //attaches the panel to the frame
        parkingFrame.setPreferredSize(new Dimension(1500, 950));        //setting the dimensions of the frame
        parkingFrame.setSize(1500,950);                                 //setting the size of the frame
        parkingFrame.setVisible(true);                                              //allowing the frame to be seen
        Container c = parkingFrame.getContentPane();                                //gaining access to the container objects in JAVA
        Component[] allStuff = c.getComponents();                                   //setting it to an array for the components

        for(level = 0; level <= 2; level++){                                        //condition for finding which level the user picks
            for(pSpace = 0; pSpace<= 9; pSpace++) {                                 //condition for giving a space to the user based on level picked
                if(spaceByLevel[level][pSpace] == 'X'){                             //checking if a spot is taken or open
                    temp = pSpace + (level * 10);
                    currLabel = pSpace + (level * 10);                              //math to find the correct parking spot for the user
                    allStuff[currLabel].setForeground(Color.red);                   //changing the parking space to red
                }
            }
        }

        SwingUtilities.updateComponentTreeUI(parkingGarage.parkingFrame);           //gaining access to the swing utilities that JAVA offers

    }

    public  Vendor() {
        levelComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                levelComboBox.getSelectedItem();                                                        //gaining access to the level selected by user

                Object selected = levelComboBox.getSelectedItem();                                      //setting that level to a variable selected

                int pSpace = 0;                                                                         //creating a pSpace count

                if (selected.toString().equals("Level 1")) {                                            //case if the user selects level one
                    pSpace = getParkingSpace(0);                                                    //setting the pSpace to the level the user wants to park on

                    if(pSpace != -1){                                                                   //check to make sure the user didn't put in an invalid number
                        spaceByLevel[0][pSpace] = 'X';                                                  //setting the open parking space on level one to their spot
                        JOptionPane.showMessageDialog(null, "Please park in space " + String.valueOf(pSpace+1) );
                        updateShowParkingSpaces();                                                      //updating the GUI parking form
                    }
                } else if (selected.toString().equals("Level 2")) {                                     //condition for if they pick level two

                    pSpace = getParkingSpace(1);                                                   //setting the pSpace to the level the user wants to park on

                    if(pSpace != -1){                                                                   //check to make sure the user didn't put in an invalid number
                        spaceByLevel[1][pSpace] = 'X';                                                  //setting the open parking space on level two to their spot
                        JOptionPane.showMessageDialog(null, "Please park in space " + String.valueOf(pSpace+11) );
                        updateShowParkingSpaces();                                                      //updating the GUI parking form
                    }
                } else if (selected.toString().equals("Level 3")) {                                     //condition for if they pick level three

                    pSpace = getParkingSpace(2);                                                   //setting the pSpace to the level the user wants to park on

                    if(pSpace != -1){                                                                   //check to make sure the user didn't put in an invalid number
                        spaceByLevel[2][pSpace] = 'X';                                                  //setting the open parking space on level three to their spot
                        JOptionPane.showMessageDialog(null, "Please park in space " + String.valueOf(pSpace+21) );
                        updateShowParkingSpaces();                                                      //updating the GUI parking form
                    }
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = 0;

                JFrame exitFrame = new JFrame("Parking Vendor");                                   //Makes the frame
                exitFrame.setContentPane(new exitVender().exitPanel);                                   //attaches the panel to the frame
                exitFrame.setPreferredSize(new Dimension(1500, 950));                      //setting the dimensions of the frame
                exitFrame.setSize(1500,950);                                               //setting the dimensions of the frame
                exitFrame.setVisible(true);                                                            //setting the frame to visible so the user can see it
                x = Integer.parseInt(JOptionPane.showInputDialog("Please enter the spot that you were in"));
                x--;                                                                                    //adjusting for zero based array

                if(x - 20 > 0 && x < 31){                                                               //setting the number of spaces for level 3
                    spaceByLevel[2][x - 20] = 'O';
                }
                else if(x - 10 > 0 && x < 21){                                                          //setting the number of spaces for level 2
                    spaceByLevel[1][x - 10] = 'O';
                }
                else if (x >= 0 && x < 11){                                                             //setting the number of spaces for level 1
                    spaceByLevel[0][x] = 'O';
                }
                else{
                    JOptionPane.showInputDialog("Incorrect number entered. Please try again: ");
                }

                SwingUtilities.updateComponentTreeUI(parkingGarage.parkingFrame);                       //gaining access to the java swing utilities

            }
        });
        cashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double due = 7.50;                                                                           //fixed parking price
                //double pay = 10.00;                                                                        //fixed payment for prototype
                int dollars = 0;                                                                            //initializing dollar variable
                int cents = 0;                                                                              //initializing a cent variable
                int quarters = 0;                                                                           //initializing a quarter variable
                int dimes = 0;                                                                              //initializing a dime variable
                int nickles = 0;                                                                            //initializing a nickle variable
                int pennies = 0;                                                                            //initializing a pennies variable
                int x = 0;
                String temp = null;                                                                         //initializing a temp string

                String y = JOptionPane.showInputDialog("What is the dollar amount you are paying with?");   //getting what the user is paying with
                double y1 = Double.parseDouble(y);                                                          //setting the string to a double for money purposes

                due = y1 - due;                                                                             //after the prototype we need to get pay from user entry
                if (due < 0) {                                                                              //condition for if the user incorrect amount
                    JOptionPane.showMessageDialog(null, "Not enough money paid");      //allowing the user to know they didn't pay enough
                } else {
                    temp = "Change due is $" + Double.toString(due);                                        //setting the change due to the temp string
                    x = (int) (due * 100);                                                                  //setting the change to 100 to make it easier to handle
                    cents = x % 100;                                                                        //taking the mod of x
                    dollars = (x - cents) / 100;                                                            //finding the number of dollars owed back
                    temp = "change due is: ";                                                               //displaying the change they owe
                    if (dollars >= 1) {                                                                     //condition if dollars owed is greater than 1
                        temp += dollars + " dollars ";                                                      //setting the dollar amount to the temp string
                    }

                    quarters = (cents - cents % 25) / 25;                                                   //looking for the correct amount of cents owed
                    cents = cents % 25;                                                                     //finding the mod for quarters

                    if (quarters >= 1) {                                                                    //checking if its greater than 1
                        temp += " " + (quarters - quarters % 1 + " quarters");                              //adding the amount to the temp string
                    }

                    dimes = (cents - cents % 10) / 10;                                                      //math to get the change left in terms of 10's
                    cents = cents % 10;                                                                     //mod for the number of dimes

                    if (dimes >= 1) {                                                                       //checking if any dimes are needed
                        temp += " " + (dimes + " dimes");                                                   //adding the amount to the temp string
                    }

                    nickles = (cents - cents % 5) / 5;                                                      //math to get the change left in terms of 5's
                    cents = cents % 5;                                                                      //mod for the number of nickels

                    if (nickles >= 1) {                                                                     //condition for the number of nickles
                        temp += " " + (nickles + " nickles");                                               //adding the amount to the temp string
                    }

                    pennies = cents;                                                                        //setting the remainder change to be equal to the pennies

                    if (pennies >= 1) {                                                                     //condition for the number of pennies
                        temp += " " + (pennies + " pennies");                                               //adding the amount to the temp string
                    }
                    JOptionPane.showMessageDialog(null, temp);                                //displaying the total change amount to user
                }
            }
        });
        creditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if the credit button gets pressed than the user will receive a pop up stating the transaction went through
                JOptionPane.showMessageDialog(null, "transaction complete");

            }
        });
        debitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //if the debit button gets pressed than the user will receive a pop up stating the transaction went through
                JOptionPane.showMessageDialog(null, "transaction complete");

            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //to reset for the next user
                JOptionPane.showMessageDialog(null, "Welcome to the parking garage, \n" +
                        "when you are finished reading this message hit okay and then \n" +
                        "you can proceed to selecting how you would like to pay. \n" +
                        "You can either pay in cash, credit or debt. Once you have paid, or before, you can hit \n" +
                        "the level combo box to see what spots are open in the parking garages on which levels.\n" +
                        "Once you have completed all of these you make the proceed to open through\n" +
                        "the opened gate.\n");
            }
        });
        instructionsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //used for when a new user comes and they need instructions on how to work the machine
                JOptionPane.showMessageDialog(null, "Welcome to the parking garage, \n" +
                        "when you are finished reading this message hit okay and then \n" +
                        "you can proceed to selecting how you would like to pay. \n" +
                        "You can either pay in cash, credit or debt. Once you have paid, or before, you can hit \n" +
                        "the level combo box to see what spots are open in the parking garages on which levels.\n" +
                        "Once you have completed all of these you make the proceed to open through\n" +
                        "the opened gate.\n");
            }
        });
    }
    public int getParkingSpace(int level){
        int x = 0;                                                              //creating a testing variable for the parking spot
        for(x = 0; x < 10; x++) {                                               //going through to find which space is open
            if(spaceByLevel[level][x] == 'O'){                                  //finding the parking spot for the user
                return x;                                                       //returning the parking spot
            }
        }

        return -1;                                                              //this if there is no open parking spots on this level
    }

    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Parking Vendor"); //Makes the frame
        myFrame.setContentPane(new Vendor().Vendor); //attaches the panel to the frame

        // Using java dimension, set the preferred size - both width and height
        myFrame.setPreferredSize(new Dimension(1500, 950));

        //sets up what happens with the frame is closes
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myFrame.pack(); //put everything in the frame
        myFrame.setVisible(true); //allows us to see the frame

        JOptionPane.showMessageDialog(null, "Welcome to the parking garage, \n" +
                "when you are finished reading this message hit okay and then \n" +
                "you can proceed to selecting how you would like to pay. \n" +
                "You can either pay in cash, credit or debt. Once you have paid, or before, you can hit \n" +
                "the level combo box to see what spots are open in the parking garages on which levels.\n" +
                "Once you have completed all of these you make the proceed to open through\n" +
                "the opened gate.\n");
    }

}

