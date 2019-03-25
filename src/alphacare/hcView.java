package alphacare;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class hcView extends JFrame {

    private JPanel objectPanel;
    private JPanel buttonPanel;

    private final hcControl hcCntrl;
    private final hcModel hcMod;
    private final MedicalRecordUI record = new MedicalRecordUI();

    public hcView(hcControl hcCntl, hcModel hcMod) {
        this.hcCntrl = hcCntl;
        this.hcMod = hcMod;

        alphaCareStarter();

    }

    private void alphaCareStarter() {
        setTitle("Login");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JTextField usernameField = new JTextField("", JTextField.CENTER);
        JTextField passwordField = new JTextField("", JTextField.CENTER);
        final String correctUsername = "mjnelson";
        final String correctPassword = "mockPassword";

        objectPanel = new JPanel(new GridLayout(3, 2));

        ImageIcon img = new ImageIcon("healthcare.png");

        objectPanel.add(new JLabel("AlphaCare", JLabel.CENTER)).setFont(new Font("Impact", 30, 40));

        objectPanel.add(new JLabel(img, JLabel.CENTER));
        
        objectPanel.add(usernameField);
        objectPanel.add(passwordField);
        
        objectPanel.add(new JLabel("Username", JLabel.CENTER));
        objectPanel.add(new JLabel("Password", JLabel.CENTER));

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton welcomeB = new JButton("Login");

        //welcomeB.addActionListener(event -> patientOptions());
        
        JButton showDialogButton = new JButton("Text Button");
        welcomeB.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e)
          {
            if(usernameField.getText().equals(correctUsername) && passwordField.getText().equals(correctPassword)){
                patientOptions();
            }else{
                JOptionPane.showMessageDialog(null, "Incorrect username/password combination");
            }
          }
        });

        buttonPanel.add(welcomeB);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(objectPanel, BorderLayout.NORTH);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

    }

    private void patientOptions() {
        setTitle("Patient Portal");
        setSize(320, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        String displayTitle = "Welcome " + hcMod.MockRecord(0) + "!";

        objectPanel = new JPanel(new GridLayout(2, 1));
        objectPanel.add(new JLabel(displayTitle, JLabel.CENTER));
        objectPanel.add(new JLabel("You have no messages to display.", JLabel.CENTER));

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton patientInfo = new JButton("Display Latest Record");
        patientInfo.addActionListener(event -> medicalForm());
        buttonPanel.add(patientInfo);

        JButton backButton = new JButton("Log Out");
        backButton.addActionListener(event -> alphaCareStarter());
        buttonPanel.add(backButton);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(objectPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
    }
    
    private void medicalForm(){
        
        // First name
        record.jTextField1.setText(hcMod.MockRecord(0));
        // Middle initial
        record.jTextField2.setText(hcMod.MockRecord(1));
        // Patient's last name
        record.jTextField3.setText(hcMod.MockRecord(2));
        // Patient's date of birth
        record.jTextField5.setText(hcMod.MockRecord(3));
        // Patient's height
        record.jTextField10.setText(hcMod.MockRecord(4));
        // Patient's weight
        record.jTextField13.setText(hcMod.MockRecord(5));
        // Patient's address
        record.jTextField6.setText(hcMod.MockRecord(6));
        // Patient's city
        record.jTextField7.setText(hcMod.MockRecord(7));
        // Patient's state
        record.jTextField8.setText(hcMod.MockRecord(8));
        // Patient's zip
        record.jTextField9.setText(hcMod.MockRecord(9));
        // Patient's phone number
        record.jTextField26.setText(hcMod.MockRecord(10));
        // Patient's gender
        record.jTextField27.setText(hcMod.MockRecord(11));
        // Patient's ethnicity
        record.jTextField25.setText(hcMod.MockRecord(12));
        // Patient's language
        record.jTextField28.setText(hcMod.MockRecord(13));
        // Patient's marital status
        record.jTextField30.setText(hcMod.MockRecord(14));
        // Patient's culture
        record.jTextField29.setText(hcMod.MockRecord(15));
        // Patient's allergies
        record.jTextArea1.setText(hcMod.MockRecord(16));
        // Patient's current medications
        record.jTextArea2.setText(hcMod.MockRecord(17));
        // Patient's drug use
        record.jTextArea3.setText(hcMod.MockRecord(18));
        // Patient conditions
        record.jTextArea4.setText(hcMod.MockRecord(19));
        // Written Report
        record.jTextArea6.setText(hcMod.MockRecord(20));
        // Symptoms
        record.jTextArea5.setText(hcMod.MockRecord(21));
        // Date of report
        record.jTextField24.setText(hcMod.MockRecord(22));
        
        record.setVisible(true);
    }

}