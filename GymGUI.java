import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * GymGUI class for managing gym memberships
 * Includes functionality to add regular and premium members,
 * activate/deactivate memberships, mark attendance, and display member information
 */
public class GymGUI implements ActionListener {
    // Main frame for the GUI
    JFrame mainFrame;
    
    // Labels for all input fields
    JLabel labelId, labelName, labelLocation, labelPhone, labelEmail, labelGender, labelDOB, 
          labelMembershipStartDate, labelReferralSource, labelPaidAmount, labelRemovalReason, 
          labelTrainerName, labelRegularPrice, labelPremiumCharge, labelDiscountAmount;
    
    // Text fields for member information
    JTextField tfId, tfName, tfLocation, tfPhone, tfEmail, tfReferralSource, tfPaidAmount, 
               tfRemovalReason, tfTrainerName, tfRegularPrice, tfPremiumCharge, tfDiscountAmount;
    
    // Combo boxes for date selection
    JComboBox<String> dobYearComboBox, dobMonthComboBox, dobDayComboBox;
    JComboBox<String> msYearComboBox, msMonthComboBox, msDayComboBox;
    
    // Radio buttons for gender selection
    JRadioButton rbMale, rbFemale;
    ButtonGroup genderGroup;
    
    // Combo box for plan selection (Regular members only)
    JComboBox<String> planComboBox;
    
    // Buttons for various operations
    JButton btnAddRegular, btnAddPremium, btnActivate, btnDeactivate, btnMarkAttendance, 
            btnRevertRegular, btnRevertPremium, btnDisplay, btnClear;
    
    // ArrayList to store both RegularMember and PremiumMember objects
    ArrayList<GymMember> memberList;
    
    /**
     * Constructor to initialize the GUI components
     */
    public GymGUI() {
        // Initialize the main frame
        mainFrame = new JFrame("Gym Membership Management System");
        
        // Initialize the member list
        memberList = new ArrayList<>();
        
        // Create and position all labels
        createLabels();
        
        // Create and position all text fields
        createTextFields();
        
        // Create and position date combo boxes
        createDateComboBoxes();
        
        // Create and position gender radio buttons
        createGenderRadioButtons();
        
        // Create and position plan combo box
        createPlanComboBox();
        
        // Create and position all buttons
        createButtons();
        
        // Set up the main frame properties
        mainFrame.setLayout(null); // Using null layout for precise positioning
        mainFrame.setSize(800, 700); // Set frame size
        mainFrame.setVisible(true); // Make frame visible
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation
    }
    
    /**
     * Method to create and position all labels
     */
    private void createLabels() {
        // Initialize all labels with their text
        labelId = new JLabel("Member ID:");
        labelName = new JLabel("Name:");
        labelLocation = new JLabel("Location:");
        labelPhone = new JLabel("Phone:");
        labelEmail = new JLabel("Email:");
        labelGender = new JLabel("Gender:");
        labelDOB = new JLabel("Date of Birth:");
        labelMembershipStartDate = new JLabel("Membership Start Date:");
        labelReferralSource = new JLabel("Referral Source:");
        labelPaidAmount = new JLabel("Paid Amount:");
        labelRemovalReason = new JLabel("Removal Reason:");
        labelTrainerName = new JLabel("Trainer's Name:");
        labelRegularPrice = new JLabel("Regular Plan Price:");
        labelPremiumCharge = new JLabel("Premium Charge:");
        labelDiscountAmount = new JLabel("Discount Amount:");
        
        // Set bounds for each label (x, y, width, height)
        labelId.setBounds(20, 20, 100, 20);
        labelName.setBounds(20, 50, 100, 20);
        labelLocation.setBounds(20, 80, 100, 20);
        labelPhone.setBounds(20, 110, 100, 20);
        labelEmail.setBounds(20, 140, 100, 20);
        labelGender.setBounds(20, 170, 100, 20);
        labelDOB.setBounds(20, 200, 100, 20);
        labelMembershipStartDate.setBounds(20, 230, 150, 20);
        labelReferralSource.setBounds(20, 260, 100, 20);
        labelPaidAmount.setBounds(20, 290, 100, 20);
        labelRemovalReason.setBounds(20, 320, 100, 20);
        labelTrainerName.setBounds(20, 350, 100, 20);
        labelRegularPrice.setBounds(400, 20, 150, 20);
        labelPremiumCharge.setBounds(400, 50, 150, 20);
        labelDiscountAmount.setBounds(400, 80, 150, 20);
        
        // Add all labels to the main frame
        mainFrame.add(labelId);
        mainFrame.add(labelName);
        mainFrame.add(labelLocation);
        mainFrame.add(labelPhone);
        mainFrame.add(labelEmail);
        mainFrame.add(labelGender);
        mainFrame.add(labelDOB);
        mainFrame.add(labelMembershipStartDate);
        mainFrame.add(labelReferralSource);
        mainFrame.add(labelPaidAmount);
        mainFrame.add(labelRemovalReason);
        mainFrame.add(labelTrainerName);
        mainFrame.add(labelRegularPrice);
        mainFrame.add(labelPremiumCharge);
        mainFrame.add(labelDiscountAmount);
    }
    
    /**
     * Method to create and position all text fields
     */
    private void createTextFields() {
        // Initialize all text fields
        tfId = new JTextField();
        tfName = new JTextField();
        tfLocation = new JTextField();
        tfPhone = new JTextField();
        tfEmail = new JTextField();
        tfReferralSource = new JTextField();
        tfPaidAmount = new JTextField();
        tfRemovalReason = new JTextField();
        tfTrainerName = new JTextField();
        
        // Non-editable text fields for prices
        tfRegularPrice = new JTextField("6500.0");
        tfRegularPrice.setEditable(false);
        tfPremiumCharge = new JTextField("50000.0");
        tfPremiumCharge.setEditable(false);
        tfDiscountAmount = new JTextField("0.0");
        tfDiscountAmount.setEditable(false);
        
        // Set bounds for each text field (x, y, width, height)
        tfId.setBounds(180, 20, 200, 20);
        tfName.setBounds(180, 50, 200, 20);
        tfLocation.setBounds(180, 80, 200, 20);
        tfPhone.setBounds(180, 110, 200, 20);
        tfEmail.setBounds(180, 140, 200, 20);
        tfReferralSource.setBounds(180, 260, 200, 20);
        tfPaidAmount.setBounds(180, 290, 200, 20);
        tfRemovalReason.setBounds(180, 320, 200, 20);
        tfTrainerName.setBounds(180, 350, 200, 20);
        tfRegularPrice.setBounds(550, 20, 150, 20);
        tfPremiumCharge.setBounds(550, 50, 150, 20);
        tfDiscountAmount.setBounds(550, 80, 150, 20);
        
        // Add all text fields to the main frame
        mainFrame.add(tfId);
        mainFrame.add(tfName);
        mainFrame.add(tfLocation);
        mainFrame.add(tfPhone);
        mainFrame.add(tfEmail);
        mainFrame.add(tfReferralSource);
        mainFrame.add(tfPaidAmount);
        mainFrame.add(tfRemovalReason);
        mainFrame.add(tfTrainerName);
        mainFrame.add(tfRegularPrice);
        mainFrame.add(tfPremiumCharge);
        mainFrame.add(tfDiscountAmount);
    }
    
    /**
     * Method to create and position date combo boxes
     */
    private void createDateComboBoxes() {
        // Arrays for date values
        String[] years = new String[100];
        String[] months = {"01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};
        String[] days = new String[31];
        
        // Populate years (from current year back 100 years)
        for (int i = 0; i < 100; i++) {
            years[i] = String.valueOf(2023 - i);
        }
        
        // Populate days (1-31)
        for (int i = 0; i < 31; i++) {
            days[i] = String.valueOf(i + 1);
        }
        
        // Initialize combo boxes for date of birth
        dobYearComboBox = new JComboBox<>(years);
        dobMonthComboBox = new JComboBox<>(months);
        dobDayComboBox = new JComboBox<>(days);
        
        // Initialize combo boxes for membership start date
        msYearComboBox = new JComboBox<>(years);
        msMonthComboBox = new JComboBox<>(months);
        msDayComboBox = new JComboBox<>(days);
        
        // Set bounds for DOB combo boxes
        dobYearComboBox.setBounds(180, 200, 60, 20);
        dobMonthComboBox.setBounds(250, 200, 50, 20);
        dobDayComboBox.setBounds(310, 200, 50, 20);
        
        // Set bounds for membership start date combo boxes
        msYearComboBox.setBounds(180, 230, 60, 20);
        msMonthComboBox.setBounds(250, 230, 50, 20);
        msDayComboBox.setBounds(310, 230, 50, 20);
        
        // Add all combo boxes to the main frame
        mainFrame.add(dobYearComboBox);
        mainFrame.add(dobMonthComboBox);
        mainFrame.add(dobDayComboBox);
        mainFrame.add(msYearComboBox);
        mainFrame.add(msMonthComboBox);
        mainFrame.add(msDayComboBox);
    }
    
    /**
     * Method to create and position gender radio buttons
     */
    private void createGenderRadioButtons() {
        // Initialize radio buttons
        rbMale = new JRadioButton("Male");
        rbFemale = new JRadioButton("Female");
        
        // Create button group for gender selection
        genderGroup = new ButtonGroup();
        genderGroup.add(rbMale);
        genderGroup.add(rbFemale);
        
        // Set bounds for radio buttons
        rbMale.setBounds(180, 170, 60, 20);
        rbFemale.setBounds(250, 170, 80, 20);
        
        // Add radio buttons to the main frame
        mainFrame.add(rbMale);
        mainFrame.add(rbFemale);
    }
    
    /**
     * Method to create and position plan combo box
     */
    private void createPlanComboBox() {
        // Array of plan options
        String[] plans = {"Basic", "Standard", "Deluxe"};
        
        // Initialize plan combo box
        planComboBox = new JComboBox<>(plans);
        
        // Set bounds for plan combo box
        planComboBox.setBounds(550, 110, 150, 20);
        
        // Add plan combo box to the main frame
        mainFrame.add(planComboBox);
    }
    
    /**
     * Method to create and position all buttons
     */
    private void createButtons() {
        // Initialize all buttons
        btnAddRegular = new JButton("Add Regular Member");
        btnAddPremium = new JButton("Add Premium Member");
        btnActivate = new JButton("Activate Membership");
        btnDeactivate = new JButton("Deactivate Membership");
        btnMarkAttendance = new JButton("Mark Attendance");
        btnRevertRegular = new JButton("Revert Regular Member");
        btnRevertPremium = new JButton("Revert Premium Member");
        btnDisplay = new JButton("Display Members");
        btnClear = new JButton("Clear Fields");
        
        // Set bounds for each button (x, y, width, height)
        btnAddRegular.setBounds(20, 400, 180, 30);
        btnAddPremium.setBounds(210, 400, 180, 30);
        btnActivate.setBounds(400, 400, 180, 30);
        btnDeactivate.setBounds(20, 440, 180, 30);
        btnMarkAttendance.setBounds(210, 440, 180, 30);
        btnRevertRegular.setBounds(400, 440, 180, 30);
        btnRevertPremium.setBounds(20, 480, 180, 30);
        btnDisplay.setBounds(210, 480, 180, 30);
        btnClear.setBounds(400, 480, 180, 30);
        
        // Set colors for buttons
        btnAddRegular.setBackground(new Color(100, 200, 100)); // Green color for regular member
        btnAddPremium.setBackground(new Color(100, 100, 200)); // Blue color for premium member
        btnClear.setBackground(Color.RED); // Red color for clear button
        btnClear.setForeground(Color.WHITE); // White text for better visibility
        
        // Make buttons opaque to show background colors
        btnAddRegular.setOpaque(true);
        btnAddPremium.setOpaque(true);
        btnClear.setOpaque(true);
        
        // Add action listeners to all buttons
        btnAddRegular.addActionListener(this);
        btnAddPremium.addActionListener(this);
        btnActivate.addActionListener(this);
        btnDeactivate.addActionListener(this);
        btnMarkAttendance.addActionListener(this);
        btnRevertRegular.addActionListener(this);
        btnRevertPremium.addActionListener(this);
        btnDisplay.addActionListener(this);
        btnClear.addActionListener(this);
        
        // Add all buttons to the main frame
        mainFrame.add(btnAddRegular);
        mainFrame.add(btnAddPremium);
        mainFrame.add(btnActivate);
        mainFrame.add(btnDeactivate);
        mainFrame.add(btnMarkAttendance);
        mainFrame.add(btnRevertRegular);
        mainFrame.add(btnRevertPremium);
        mainFrame.add(btnDisplay);
        mainFrame.add(btnClear);
    }
    
    /**
     * Action listener method to handle button clicks
     * @param ae ActionEvent object containing event details
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnAddRegular) {
            addRegularMember();
        } else if (ae.getSource() == btnAddPremium) {
            addPremiumMember();
        } else if (ae.getSource() == btnActivate) {
            activateMembership();
        } else if (ae.getSource() == btnDeactivate) {
            deactivateMembership();
        } else if (ae.getSource() == btnMarkAttendance) {
            markAttendance();
        } else if (ae.getSource() == btnRevertRegular) {
            revertRegularMember();
        } else if (ae.getSource() == btnRevertPremium) {
            revertPremiumMember();
        } else if (ae.getSource() == btnDisplay) {
            displayMembers();
        } else if (ae.getSource() == btnClear) {
            clearFields();
        }
    }
    
    /**
     * Method to add a regular member to the system
     */
    private void addRegularMember() {
        try {
            // Get all input values
            int id = Integer.parseInt(tfId.getText());
            String name = tfName.getText();
            String location = tfLocation.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            
            // Get selected gender
            String gender = rbMale.isSelected() ? "Male" : "Female";
            
            // Construct date strings from combo boxes
            String dob = dobYearComboBox.getSelectedItem() + "-" + 
                         dobMonthComboBox.getSelectedItem() + "-" + 
                         dobDayComboBox.getSelectedItem();
            
            String membershipStartDate = msYearComboBox.getSelectedItem() + "-" + 
                                      msMonthComboBox.getSelectedItem() + "-" + 
                                      msDayComboBox.getSelectedItem();
            
            String referralSource = tfReferralSource.getText();
            
            // Check if member ID already exists
            if (isMemberIdExists(id)) {
                JOptionPane.showMessageDialog(mainFrame, "Member ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Create new RegularMember object
            RegularMember newMember = new RegularMember(id, name, location, phone, email, 
                                                       gender, dob, membershipStartDate, referralSource);
            
            // Add to member list
            memberList.add(newMember);
            
            // Show success message
            JOptionPane.showMessageDialog(mainFrame, "Regular member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            // Handle invalid number input
            JOptionPane.showMessageDialog(mainFrame, "Invalid input! Please check your entries.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Handle other exceptions
            JOptionPane.showMessageDialog(mainFrame, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Method to add a premium member to the system
     */
    private void addPremiumMember() {
        try {
            // Get all input values
            int id = Integer.parseInt(tfId.getText());
            String name = tfName.getText();
            String location = tfLocation.getText();
            String phone = tfPhone.getText();
            String email = tfEmail.getText();
            
            // Get selected gender
            String gender = rbMale.isSelected() ? "Male" : "Female";
            
            // Construct date strings from combo boxes
            String dob = dobYearComboBox.getSelectedItem() + "-" + 
                       dobMonthComboBox.getSelectedItem() + "-" + 
                       dobDayComboBox.getSelectedItem();
            
            String membershipStartDate = msYearComboBox.getSelectedItem() + "-" + 
                                       msMonthComboBox.getSelectedItem() + "-" + 
                                       msDayComboBox.getSelectedItem();
            
            String trainerName = tfTrainerName.getText();
            
            // Check if member ID already exists
            if (isMemberIdExists(id)) {
                JOptionPane.showMessageDialog(mainFrame, "Member ID already exists!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            // Create new PremiumMember object
            PremiumMember newMember = new PremiumMember(id, name, location, phone, email, 
                                                      gender, dob, membershipStartDate, trainerName);
            
            // Add to member list
            memberList.add(newMember);
            
            // Show success message
            JOptionPane.showMessageDialog(mainFrame, "Premium member added successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException e) {
            // Handle invalid number input
            JOptionPane.showMessageDialog(mainFrame, "Invalid input! Please check your entries.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            // Handle other exceptions
            JOptionPane.showMessageDialog(mainFrame, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Method to check if a member ID already exists in the system
     * @param id The member ID to check
     * @return true if the ID exists, false otherwise
     */
    private boolean isMemberIdExists(int id) {
        for (GymMember member : memberList) {
            if (member.getId() == id) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Method to activate a membership
     */
    private void activateMembership() {
        try {
            int id = Integer.parseInt(tfId.getText());
            GymMember member = findMemberById(id);
            
            if (member != null) {
                member.activateMembership();
                JOptionPane.showMessageDialog(mainFrame, "Membership activated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid member ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Method to deactivate a membership
     */
    private void deactivateMembership() {
        try {
            int id = Integer.parseInt(tfId.getText());
            GymMember member = findMemberById(id);
            
            if (member != null) {
                member.deactivateMembership();
                JOptionPane.showMessageDialog(mainFrame, "Membership deactivated successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid member ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Method to mark attendance for a member
     */
    private void markAttendance() {
        try {
            int id = Integer.parseInt(tfId.getText());
            GymMember member = findMemberById(id);
            
            if (member != null) {
                if (member.isActiveStatus()) {
                    member.markAttendance();
                    JOptionPane.showMessageDialog(mainFrame, "Attendance marked successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(mainFrame, "Member is not active!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(mainFrame, "Member not found!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid member ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Method to revert a regular member
     */
    private void revertRegularMember() {
        try {
            int id = Integer.parseInt(tfId.getText());
            String removalReason = tfRemovalReason.getText();
            
            for (GymMember member : memberList) {
                if (member.getId() == id && member instanceof RegularMember) {
                    ((RegularMember) member).revertRegularMember(removalReason);
                    JOptionPane.showMessageDialog(mainFrame, "Regular member reverted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(mainFrame, "Regular member not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid member ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Method to revert a premium member
     */
    private void revertPremiumMember() {
        try {
            int id = Integer.parseInt(tfId.getText());
            
            for (GymMember member : memberList) {
                if (member.getId() == id && member instanceof PremiumMember) {
                    ((PremiumMember) member).revertPremiumMember();
                    JOptionPane.showMessageDialog(mainFrame, "Premium member reverted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
            }
            JOptionPane.showMessageDialog(mainFrame, "Premium member not found!", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(mainFrame, "Invalid member ID!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Method to display all members in a new window
     */
    private void displayMembers() {
        // Create a new frame for displaying members
        JFrame displayFrame = new JFrame("Member Information");
        displayFrame.setSize(600, 400);
        displayFrame.setLayout(new BorderLayout());
        
        // Create a text area to display member information
        JTextArea displayArea = new JTextArea();
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);
        
        // Add all member information to the text area
        for (GymMember member : memberList) {
            displayArea.append("Member Type: " + (member instanceof RegularMember ? "Regular" : "Premium") + "\n");
            displayArea.append("ID: " + member.getId() + "\n");
            displayArea.append("Name: " + member.getName() + "\n");
            displayArea.append("Location: " + member.getLocation() + "\n");
            displayArea.append("Phone: " + member.getPhone() + "\n");
            displayArea.append("Email: " + member.getEmail() + "\n");
            displayArea.append("Gender: " + member.getGender() + "\n");
            displayArea.append("DOB: " + member.getDOB() + "\n");
            displayArea.append("Membership Start Date: " + member.getMembershipStartDate() + "\n");
            displayArea.append("Attendance: " + member.getAttendance() + "\n");
            displayArea.append("Loyalty Points: " + member.getLoyaltyPoints() + "\n");
            displayArea.append("Active Status: " + member.isActiveStatus() + "\n");
            
            if (member instanceof RegularMember) {
                RegularMember rm = (RegularMember) member;
                displayArea.append("Plan: " + rm.getPlan() + "\n");
                displayArea.append("Price: " + rm.getPrice() + "\n");
                displayArea.append("Referral Source: " + rm.getReferralSource() + "\n");
                if (!rm.getRemovalReason().isEmpty()) {
                    displayArea.append("Removal Reason: " + rm.getRemovalReason() + "\n");
                }
            } else if (member instanceof PremiumMember) {
                PremiumMember pm = (PremiumMember) member;
                displayArea.append("Personal Trainer: " + pm.getPersonalTrainer() + "\n");
                displayArea.append("Paid Amount: " + pm.getPaidAmount() + "\n");
                displayArea.append("Premium Charge: " + pm.getPremiumCharge() + "\n");
                displayArea.append("Is Full Payment: " + pm.getIsFullPayment() + "\n");
                if (pm.getIsFullPayment()) {
                    displayArea.append("Discount Amount: " + pm.getDiscountAmount() + "\n");
                }
            }
            
            displayArea.append("\n----------------------------------------\n\n");
        }
        
        // Add the text area to the frame and make it visible
        displayFrame.add(scrollPane, BorderLayout.CENTER);
        displayFrame.setVisible(true);
    }
    
    /**
     * Method to clear all input fields
     */
    private void clearFields() {
        // Clear all text fields
        tfId.setText("");
        tfName.setText("");
        tfLocation.setText("");
        tfPhone.setText("");
        tfEmail.setText("");
        tfReferralSource.setText("");
        tfPaidAmount.setText("");
        tfRemovalReason.setText("");
        tfTrainerName.setText("");
        
        // Reset gender selection
        genderGroup.clearSelection();
        
        // Reset date selections to first option
        dobYearComboBox.setSelectedIndex(0);
        dobMonthComboBox.setSelectedIndex(0);
        dobDayComboBox.setSelectedIndex(0);
        msYearComboBox.setSelectedIndex(0);
        msMonthComboBox.setSelectedIndex(0);
        msDayComboBox.setSelectedIndex(0);
        
        // Reset plan selection to first option
        planComboBox.setSelectedIndex(0);
    }
    
    /**
     * Helper method to find a member by ID
     * @param id The member ID to search for
     * @return The GymMember object if found, null otherwise
     */
    private GymMember findMemberById(int id) {
        for (GymMember member : memberList) {
            if (member.getId() == id) {
                return member;
            }
        }
        return null;
    }
    
    /**
     * Main method to start the application
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create and show the GUI
        new GymGUI();
    }
}