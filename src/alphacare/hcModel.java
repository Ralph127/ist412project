package alphacare;


import java.util.ArrayList;


/**
 *
 * @author Rodrigo
 */
public class hcModel {

    final ArrayList<String[]> patientRecords = new ArrayList<>();

    // Generates 3 mock medical records for a single patient
    public hcModel() {
        
        String[] record1Info = new String[23];
        String[] record2Info = new String[23];
        String[] record3Info = new String[23];
        
        // Information for mock patient's first mock medical record
        // First name
        record1Info[0] = "Mike";
        // Middle initial
        record1Info[1] = "J";
        // Patient's last name
        record1Info[2] = "Nelson";
        // Patient's date of birth
        record1Info[3] = "04/08/1998";
        // Patient's height
        record1Info[4] = "62 inches";
        // Patient's weight
        record1Info[5] = "184 pounds";
        // Patient's address
        record1Info[6] = "351 State Drive";
        // Patient's city
        record1Info[7] = "Collegeville";
        // Patient's state
        record1Info[8] = "PA";
        // Patient's zip
        record1Info[9] = "15820";
        // Patient's phone number
        record1Info[10] = "(814) 237-8712";
        // Patient's gender
        record1Info[11] = "Male";
        // Patient's ethnicity
        record1Info[12] = "White";
        // Patient's language
        record1Info[13] = "English";
        // Patient's marital status
        record1Info[14] = "Single";
        // Patient's culture
        record1Info[15] = "Northeastern American";
        // Patient's allergies
        record1Info[16] = "None";
        // Patient's current medications
        record1Info[17] = "None";
        // Patient's drug use
        record1Info[18] = "Drinks occasionally";
        // Patient conditions
        record1Info[19] = "None";
        // Written Report
        record1Info[20] = "The patient came in complaining about an earache, muffled hearing, and nausea and it was determined during my analysis that the patient has ear drainage.";
        // Symptoms
        record1Info[21] = "Earache, muffled hearing, and nausea.";
        // Date of report
        record1Info[22] = "03/20/2019";
        
        // Information for mock patient's first mock medical record
        // First name
        record2Info[0] = "Mike";
        // Middle initial
        record2Info[1] = "J";
        // Patient's last name
        record2Info[2] = "Nelson";
        // Patient's date of birth
        record2Info[3] = "04/08/1998";
        // Patient's height
        record2Info[4] = "62 inches";
        // Patient's weight
        record2Info[5] = "182 pounds";
        // Patient's address
        record2Info[6] = "351 State Drive";
        // Patient's city
        record2Info[7] = "Collegeville";
        // Patient's state
        record2Info[8] = "PA";
        // Patient's zip
        record2Info[9] = "15820";
        // Patient's phone number
        record2Info[10] = "(814) 237-8712";
        // Patient's gender
        record2Info[11] = "Male";
        // Patient's ethnicity
        record2Info[12] = "White";
        // Patient's language
        record2Info[13] = "English";
        // Patient's marital status
        record2Info[14] = "Single";
        // Patient's culture
        record2Info[15] = "Northeastern American";
        // Patient's allergies
        record2Info[16] = "None";
        // Patient's current medications
        record2Info[17] = "None";
        // Patient's drug use
        record2Info[18] = "Drinks occasionally";
        // Patient conditions
        record2Info[19] = "None";
        // Written Report
        record2Info[20] = "The patient came in complaining about frequent urination, weight loss, and fatigue and it was determined during my analysis that the patient has a skin infection.";
        // Symptoms
        record2Info[21] = "Urination issues, weight change, fatigue.";
        // Date of report
        record2Info[22] = "02/19/2019";
        
        // Information for mock patient's first mock medical record
        // First name
        record3Info[0] = "Mike";
        // Middle initial
        record3Info[1] = "J";
        // Patient's last name
        record3Info[2] = "Nelson";
        // Patient's date of birth
        record3Info[3] = "04/08/1998";
        // Patient's height
        record3Info[4] = "62 inches";
        // Patient's weight
        record3Info[5] = "184 pounds";
        // Patient's address
        record3Info[6] = "351 State Drive";
        // Patient's city
        record3Info[7] = "Collegeville";
        // Patient's state
        record3Info[8] = "PA";
        // Patient's zip
        record3Info[9] = "15820";
        // Patient's phone number
        record3Info[10] = "(814) 237-8712";
        // Patient's gender
        record3Info[11] = "Male";
        // Patient's ethnicity
        record3Info[12] = "White";
        // Patient's language
        record3Info[13] = "English";
        // Patient's marital status
        record3Info[14] = "Single";
        // Patient's culture
        record3Info[15] = "Northeastern American";
        // Patient's allergies
        record3Info[16] = "None";
        // Patient's current medications
        record3Info[17] = "None";
        // Patient's drug use
        record3Info[18] = "Drinks occasionally";
        // Patient conditions
        record3Info[19] = "None";
        // Written Report
        record3Info[20] = "The patient came in complaining about a stuffy nose, cough, and headaches and it was determined during my analysis that the patient has a fever.";
        // Symptoms
        record3Info[21] = "Stuffy nose, cough, headache.";
        // Date of report
        record3Info[22] = "01/25/2019";
        
        patientRecords.add(record1Info);
        patientRecords.add(record2Info);
        patientRecords.add(record3Info);
    }

    public String[] ListRecords(int patientType, int gender) { 

        String[] AllMale = new String[3];

        AllMale[0] = ("Name: Jeff Burgos Age: 25 PlanType: 0021");
        AllMale[1] = ("Name: Zen Krim Age: 29 PlanType: 0024");
        AllMale[2] = ("Name: Matt Anetok Age: 45 PlanType: 043B");


        String[] AllFemale = new String[3];

        AllFemale[0] = ("Name: Kat Will Age: 32 PlanType: 0041");
        AllFemale[1] = ("Name: Jessica Blimes Age: 27 PlanType: 0024");
        AllFemale[2] = ("Name: Sara Buttons Age: 21 PlanType: 001");


        String[] TodayMale = new String[1];
        
        TodayMale[0] = ("Name: Jeff Burgos Age: 25 PlanType: 0021");


        String[] TodayFemale = new String[1];

        TodayFemale[0] = ("Name: Kat Will Age: 32 PlanType: 0041");


        if (gender == 0 && patientType == 0) {
            return TodayMale;

        } else if (gender == 0 && patientType == 1) {
            return AllMale;
        } else if (gender == 1 && patientType == 1) {
            return AllFemale;
        } else {
            return TodayFemale;
        }

    }
    
    
    public String[] getMockRecord(int i) {
        
        return patientRecords.get(i);
    }

}
