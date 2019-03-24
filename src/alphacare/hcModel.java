package alphacare;


import java.util.ArrayList;


/**
 *
 * @author Rodrigo
 */
public class hcModel {

    private final ArrayList<String> patientRecords = new ArrayList<>();


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
    
    public String MockRecord(int i) {
        
        String[] recordInfo = new String[21];
        
        // First name
        recordInfo[0] = "Mike";
        // Middle initial
        recordInfo[1] = "J";
        // Patient's last name
        recordInfo[2] = "Nelson";
        // Patient's date of birth
        recordInfo[3] = "04/08/1998";
        // Patient's height
        recordInfo[4] = "62 inches";
        // Patient's weight
        recordInfo[5] = "184 pounds";
        // Patient's address
        recordInfo[6] = "351 State Drive";
        // Patient's city
        recordInfo[7] = "Collegeville";
        // Patient's state
        recordInfo[8] = "PA";
        // Patient's zip
        recordInfo[9] = "15820";
        // Patient's phone number
        recordInfo[10] = "(814) 237-8712";
        // Patient's gender
        recordInfo[11] = "Male";
        // Patient's ethnicity
        recordInfo[12] = "White";
        // Patient's language
        recordInfo[13] = "English";
        // Patient's marital status
        recordInfo[14] = "Single";
        // Patient's culture
        recordInfo[15] = "Northeastern American";
        // Patient's allergies
        recordInfo[16] = "None";
        // Patient's current medications
        recordInfo[17] = "None";
        // Patient's drug use
        recordInfo[18] = "Drinks occasionally";
        // Patient conditions
        recordInfo[19] = "None";
        // Written Report
        recordInfo[20] = "The patient came in complaining about an earache, muffled hearing, and nausea and it was determined during my analysis that the patient has ear drainage.";
        
        return recordInfo[i];
    }

}
