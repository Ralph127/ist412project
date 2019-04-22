package alphacare;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.UIManager;
import javax.swing.text.DefaultCaret;


public class hcView extends JFrame {

    private JPanel objectPanel;
    private JPanel recordPanel;
    private JPanel loginPanel;
    private JPanel buttonPanel;

    private final hcControl hcCntrl;
    private final hcModel hcMod;
    private final MedicalRecordUI record = new MedicalRecordUI();
    private final AnalysisUI analysis = new AnalysisUI();

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
        JPasswordField passwordField = new JPasswordField("", JTextField.CENTER);
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

        loginPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton welcomeB = new JButton("Login");
        
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

        loginPanel.add(welcomeB);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(objectPanel, BorderLayout.NORTH);
        getContentPane().add(loginPanel, BorderLayout.SOUTH);

    }

    private void patientOptions() {
        
        getContentPane().removeAll();
        
        setTitle("Patient Portal");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        String displayTitle = "Welcome " + (String)Array.get(hcMod.getMockRecord(0), 0) + "!";

        objectPanel = new JPanel(new GridLayout(2, 1));
        objectPanel.add(new JLabel(displayTitle, JLabel.CENTER));
        objectPanel.add(new JLabel("You have no messages to display.", JLabel.CENTER));
        
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() instanceof JButton) {
                    String text = (((JButton) e.getSource()).getText()).substring(20);
                    for (int i = 0; i < hcMod.patientRecords.size(); i++){
                        if (text.equals((String)Array.get(hcMod.getMockRecord(i), 22))){
                            medicalForm(i);
                        }
                    }
                }
            }
        };
        
        ActionListener analyzeListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (ae.getSource() instanceof JButton) {
                   analysisForm();
                }
            }
        };
        
        recordPanel = new JPanel(new GridLayout(hcMod.patientRecords.size() + 1, 1));
        JButton[] buttonList = new JButton[hcMod.patientRecords.size()];
        for (int i = 0; i < hcMod.patientRecords.size(); i++){
            //JButton recordButton = new JButton("Medical record from " + (String)Array.get(hcMod.MockRecord(i), 3));
            //recordButton.addActionListener(listener);
            buttonList[i] = new JButton("Medical record from " + (String)Array.get(hcMod.getMockRecord(i), 22));
            buttonList[i].addActionListener(listener);
            recordPanel.add(buttonList[i]);
        }
        
        JButton newRecord = new JButton("Patient Care Monitor");
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(newRecord);
        newRecord.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JFrame frame = new JFrame("Patient Alert System");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                
                JPanel panel = new JPanel();
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                panel.setOpaque(true);               
                String description = "✞Enter Patient Current Medical Condition Below";
                JTextArea textArea = new JTextArea(description);
                textArea.setWrapStyleWord(true);
                textArea.setEditable(false);
                textArea.setFont(Font.getFont(Font.SANS_SERIF));
                JScrollPane scroller = new JScrollPane(textArea);
                scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
                scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
                JPanel inputpanel = new JPanel();
                inputpanel.setLayout(new FlowLayout());
                JLabel HeartRate = new JLabel("HeartRate");
                JTextField input = new JTextField(20);
                JLabel Temperature  = new JLabel("Temperature");
                JTextField input_2 = new JTextField(20);
                JLabel BloodPressure = new JLabel("Blood Pressure");
                JTextField input_3 = new JTextField(20);
                JLabel Weight = new JLabel("Weight");
                JTextField input_4 = new JTextField(20);
                JLabel Height = new JLabel("Height");
                JTextField input_5 = new JTextField(20);

                JButton button = new JButton("Enter");
                DefaultCaret caret = (DefaultCaret) textArea.getCaret();
                caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                panel.add(scroller);
                
                inputpanel.add(HeartRate);
                inputpanel.add(input);
                inputpanel.add(Temperature);
                inputpanel.add(input_2);
                inputpanel.add(BloodPressure);
                inputpanel.add(input_3);
                inputpanel.add(Weight);
                inputpanel.add(input_4);
                inputpanel.add(Height);
                inputpanel.add(input_5);
                inputpanel.add(button);
                panel.add(inputpanel);
                frame.getContentPane().add(BorderLayout.CENTER, panel);
                frame.pack();
                frame.setLocationByPlatform(true);
                frame.setVisible(true);
                frame.setResizable(false);
                input.requestFocus();
                button.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent q)
                    {
                       JFrame frame = new JFrame("Alert");
                       frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                       frame.setLayout(new BorderLayout());
                       frame.setSize(400,100);
                       JPanel panel = new JPanel();
                       panel.setOpaque(false);
                      
                       frame.setVisible(true);
                       frame.getContentPane().add(BorderLayout.CENTER, panel);
         
                       JLabel warning  = new JLabel("Patient needs to be seen by a doctor!");    
                       
                           
                       panel.add(warning);
                    }
                });
            }
        });
        
        JButton analyzeButton = new JButton("Analyze Data");
        analyzeButton.addActionListener(analyzeListener);
        buttonPanel.add(analyzeButton);

        JButton backButton = new JButton("Log Out");
        backButton.addActionListener(event -> alphaCareStarter());
        buttonPanel.add(backButton);

        setContentPane(new JPanel(new BorderLayout()));
        getContentPane().add(objectPanel, BorderLayout.NORTH);
        getContentPane().add(recordPanel, BorderLayout.CENTER);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);
        getContentPane().revalidate();
    }
    
    private void medicalForm(int i){
        
        String[] recordHolder = hcMod.getMockRecord(i);
        
        // First name
        record.name.setText(recordHolder[0]);
        // Middle initial
        record.middleName.setText(recordHolder[1]);
        // Patient's last name
        record.lastName.setText(recordHolder[2]);
        // Patient's date of birth
        record.dateOfBirth.setText(recordHolder[3]);
        // Patient's height
        record.height.setText(recordHolder[4]);
        // Patient's weight
        record.weight.setText(recordHolder[5]);
        // Patient's address
        record.address.setText(recordHolder[6]);
        // Patient's city
        record.city.setText(recordHolder[7]);
        // Patient's state
        record.state.setText(recordHolder[8]);
        // Patient's zip
        record.zipCode.setText(recordHolder[9]);
        // Patient's phone number
        record.phoneNumber.setText(recordHolder[10]);
        // Patient's gender
        record.gender.setText(recordHolder[11]);
        // Patient's ethnicity
        record.ethnicity.setText(recordHolder[12]);
        // Patient's language
        record.languagePreference.setText(recordHolder[13]);
        // Patient's marital status
        record.martialStatus.setText(recordHolder[14]);
        // Patient's culture
        record.culturalPreference.setText(recordHolder[15]);
        // Patient's allergies
        record.allergies.setText(recordHolder[16]);
        // Patient's current medications
        record.medications.setText(recordHolder[17]);
        // Patient's drug use
        record.drugs.setText(recordHolder[18]);
        // Patient conditions
        record.currentConditions.setText(recordHolder[19]);
        // Written Report
        record.todaysReport.setText(recordHolder[20]);
        // Symptoms
        record.currentSymptoms.setText(recordHolder[21]);
        // Date of report
        record.todaysDate.setText(recordHolder[22]);
        record.inputFieldsForExport(recordHolder);
        record.setVisible(true);
    }
    
    //Provides an overview for all data for the patient
    private void analysisForm(){
        
       ArrayList<String[]> records = hcMod.getmockRecordList();
       //The first record is for getting information that generally does not change
       String[] firstRecord = records.get(0);
       
       analysis.title.setText("Analysis for " + records.get(0)[0]);
       
       analysis.jTextArea1.append("Name " + firstRecord[0] + ", " + firstRecord[1] + ", " + firstRecord[2] + ", " + "\n");
       analysis.jTextArea1.append("Gender " + firstRecord[11] + "\n");
       analysis.jTextArea1.append("Ethicity " + firstRecord[12] + "\n");
       analysis.jTextArea1.append("Date of Birth " + firstRecord[3] + "\n");
       analysis.jTextArea1.append("Address " + firstRecord[6] + ", " + firstRecord[7] + ", " + firstRecord[8] + "\n");
       analysis.jTextArea1.append("Phone Number " + firstRecord[10] + "\n");
       analysis.jTextArea1.append("\n");
       
        formatAnalysis(4, "height", records);
        formatAnalysis(5, "weight", records);
        formatAnalysis(19, "conditions", records);
        formatAnalysis(21, "symptoms", records);
        
        analysis.setVisible(true);
    }
    
    private void formatAnalysis(int recordNumber, String measurementTitle, ArrayList<String[]> records){
        analysis.jTextArea1.append(records.get(0)[0] + "'s " + measurementTitle + " over time \n");
        
        for(String[] record : records){
           analysis.jTextArea1.append(record[22] + " ");
           analysis.jTextArea1.append(record[recordNumber] + " " + "\n");
       }
        analysis.jTextArea1.append("\n");
    }

}
